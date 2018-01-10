package stu.wl.twitter.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import stu.wl.twitter.dao.DynamicDao;
import stu.wl.twitter.domain.Dynamic;
import stu.wl.twitter.domain.User;

@Repository("dynamicdao")
public class DynamicDaoImpl extends BaseDaoImpl<Dynamic> implements DynamicDao{
	
	//获取自己的全部动态
	public List<Dynamic> getDynamicsByUser(User user){
		Session session  = super.getSession();
		Transaction tx = session.beginTransaction();
		
		List list = (List) session.createNativeQuery("SELECT * FROM t_dynamic WHERE user_id = '"+user.getUserid()+"' ORDER BY deliver_time DESC").getResultList();
		List<Dynamic> dynamics = this.getDynamicList(list,session);
		tx.commit();
		session.close();
		return dynamics;
	}
	
	//获取用户和关注的人的动态
	public List<Dynamic> getDynamicsByUserAndFocus(User user){
		Session session  = super.getSession();
		Transaction tx = session.beginTransaction();
		
		List list =  (List) session.createNativeQuery("SELECT * FROM t_dynamic WHERE user_id = any(SELECT focus_id FROM T_FOCUSANDFANS WHERE fans_id = '"+user.getUserid()+"') OR user_id = '"+user.getUserid()+"' ORDER BY deliver_time DESC").getResultList();
		List<Dynamic> dynamics = this.getDynamicList(list, session);
		
		tx.commit();
		session.close();
		return dynamics;
	}
	
	/*获取用户的关注的人的动态*/
	public List<Dynamic> getDynamicsByUserByfocus(User user){
		Session session  = super.getSession();
		Transaction tx = session.beginTransaction();
		
		List list =  (List) session.createNativeQuery("SELECT * FROM t_dynamic WHERE user_id = any(SELECT focus_id FROM T_FOCUSANDFANS WHERE fans_id = '"+user.getUserid()+"') ORDER BY deliver_time DESC").getResultList();
		List<Dynamic> dynamics = this.getDynamicList(list, session);
		
		tx.commit();
		session.close();
		
		return dynamics;
	}
	
	//返回动态集合
		public List<Dynamic> getDynamicList(List list,Session session){
			List<Dynamic> dynamics = new LinkedList<Dynamic>();
			Dynamic dynamic = null;
			for(int i = 0; i < list.size(); i++){
				Object[] obj = (Object[]) list.get(i);
				String content = null;
				Timestamp deliverTime =	null;
				Object like_number = 0;	
				String path = null;
				String topic = null;
				String userid = null ; 
				for(int j = 0; j < obj.length;j++){
					content = (String) obj[1];
					deliverTime =(Timestamp) obj[2];
					like_number = obj[3];
					path = (String) obj[4];
					topic = (String) obj[5];
					userid = (String) obj[6];
				}
				
				//将都取出来的每行数据存储进dynamic对象集合里
				{
					dynamic = new Dynamic();
					dynamic.setUser(session.get(User.class, userid));
					dynamic.setContent(content);
					//将日期格式化转换
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
					dynamic.setDeliver_time(sdf.format(deliverTime));
					
					//将点赞转换
					int number = 0;
					if(like_number == null){		//如果传来的是字符串
						dynamic.setLike_number(number);
					}else{
						dynamic.setLike_number((int)like_number);
					}
					
					dynamic.setPath(path);
					dynamic.setTopic(topic);
				}
				dynamics.add(dynamic);
				System.out.println("a:"+dynamic);

			}
			return dynamics;
		}
	
	
}




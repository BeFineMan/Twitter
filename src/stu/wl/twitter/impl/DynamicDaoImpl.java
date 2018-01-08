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
	
	/*获取用户的关注的人的动态*/
	public List<Dynamic> getDynamicsByUserByfocus(User user){
		Session session  = super.getSession();
		Transaction tx = session.beginTransaction();
		
		List list =  (List) session.createNativeQuery("SELECT * FROM t_dynamic WHERE user_id = any(SELECT user_id FROM t_user WHERE focusUser_id = '"+user.getUserid()+"') ORDER BY deliver_time DESC").getResultList();
		List<Dynamic> dynamics = new LinkedList<Dynamic>();
		Dynamic dynamic = null;
		for(int i = 0; i < list.size(); i++){
			Object[] obj = (Object[]) list.get(i);
			
			String dynamicId = null;
			String content = null;
			Timestamp deliverTime =	null;
			String like_number = null;	
			String path = null;
			String topic = null;
			for(int j = 0; j < obj.length;j++){
				dynamicId = (String) obj[0];
				content = (String) obj[1];
				deliverTime = (Timestamp) obj[2];
				like_number =  (String) obj[3];
				path = (String) obj[4];
				topic = (String) obj[5];
			}
			
			//将都取出来的每行数据存储进dynamic对象集合里
			{
				dynamic = new Dynamic();
				dynamic.setUser(session.get(User.class, dynamicId));
				dynamic.setContent(content);
				//将日期格式化转换
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
				dynamic.setDeliver_time(sdf.format(deliverTime));
				
				//将点赞转换
				int number;
				if(like_number == null){
					number = 0;
				}else{
					number = Integer.parseInt(like_number);
				}
				dynamic.setLike_number(number);
				dynamic.setPath(path);
				dynamic.setTopic(topic);
				dynamics.add(dynamic);
			}
			
		}
		tx.commit();
		session.close();
		
		return dynamics;
	}
	
	
	
}




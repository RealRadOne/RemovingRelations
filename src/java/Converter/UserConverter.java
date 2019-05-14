package Converter;
import Model.*;
import org.bson.types.ObjectId;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
/**
 *
 * @author Sakshi Sinha
 */
public class UserConverter 
{
 //Convert User Object to MongoDBObject
 public static DBObject toDBObject(User u) 
 {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start();
		builder.append("_id",u.getUserId());
                builder.append("Name",u.getName());
                builder.append("Email",u.getEmail());
		return builder.get();
 }
 public static User toUser(DBObject doc) 
 {
		User u = new User();
		u.setName((String) doc.get("Name"));
		u.setEmail((String) doc.get("Email"));
		ObjectId id = (ObjectId) doc.get("_id");
		u.setUserId(id.toString());
		return u;	
 }
}

import play.*;
import play.db.jpa.JPA;

public class Global extends GlobalSettings{
	public void onStart(Application app){
		JPA.withTransaction(new play.libs.F.Callback0() {
            @Override
            public void invoke() throws Throwable {
               
            }
        });
	}
	
	public void onStop(Application app){
		
	}
}

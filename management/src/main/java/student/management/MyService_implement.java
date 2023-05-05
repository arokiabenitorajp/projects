package student.management;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MyService_implement implements MyService {
	@Autowired
	private TeacherRepository teacherrepo;
	@Override
	public boolean tocheck(TeacherLoginEntity tlle)
	{
		try
		{
		System.out.println(tlle.getPassword()); 
		System.out.println(tlle.getUsername());
		System.out.println("********* 4 ****************");
		Integer pass = tlle.getPassword();
		Optional<TeacherLoginEntity> tl = teacherrepo.findById(pass);
		TeacherLoginEntity tle =	tl.get();
		
	//	TeacherLoginEntity tle=teacherrepo.toGetAllPassword(tlle.getPassword());

	System.out.println(tle.getUsername()+" --->  "+tle.getPassword());
	
	if(tle.getPassword().equals(tlle.getPassword()))
	{
		System.out.println("--> correct <--");
		return true;
	}
	}
	catch(NoSuchElementException ne)
	{
		System.out.println("--> incorrect <--");
	}

		return false;
	
	}

}

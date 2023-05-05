package student.management;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/management")
public class ControllerSystem {
	
	  @Autowired private TeacherRepository teacherrep;
	 @Autowired private EntityClass enclass;
	 @Autowired private StudentDetailRepository studentrep;
	 @Autowired
	 private MyService serve;
	 
	
	
	@GetMapping("/indexPage")
	public String getIndexPage()
	{
		System.out.println("front page");
		return "index";
	}
	
	@GetMapping("login page")
	public String getLoginPage()
	{
		System.out.println("getLoginPage");
		return "login";
	}
	
	@GetMapping("studentDetailPage")
	public String getStudentDetailPage(TeacherLoginEntity tle )
	{
		
		//teacherrep.save(tle);
		if(serve.tocheck(tle))
		{
			System.out.println("****** Check true *********");
			//return "student_page";
			return "optional";
		}
		else 
		{
			System.out.println("****** Check false *********");
			return "return_loginpage";
		}
		      } 
	@GetMapping("go student page")
	public String goToStudentPage()
	{
		return "student_page";
	}
	
	@GetMapping("search")
	
	public String getSearchPage(EntityClass enclass )
	{
		
		studentrep.save(enclass);
		System.out.println("--->sucessfully detail insert<---");
		
		
			return "search_student";
		      } 
	@GetMapping("get_details")
	public ModelAndView get_details(EntityClass enclass , ModelAndView mav,ModelAndView mav2)
	{
		try {
		//ModelAndView mav=new ModelAndView("get_detailpage");
	    Integer roll= enclass.getRollnumber();
		//EntityClass getdetail=studentrep.findById(roll).orElse(new EntityClass());
	    Optional<EntityClass> detail=studentrep.findById(roll);
	    EntityClass getdetails=detail.get();
	    mav.setViewName("get_detailpage");
		mav.addObject("roll",getdetails.getRollnumber() );
		mav.addObject("name",getdetails.getName() );
		mav.addObject("tamil",getdetails.getTamil() );
		mav.addObject("english",getdetails.getEnglish() );
		mav.addObject("maths",getdetails.getMaths() );
		mav.addObject("science",getdetails.getScience() );
		mav.addObject("social",getdetails.getSocial());
		return mav;
		}
		catch (NoSuchElementException nn)
		{
			System.out.println("--> NO SUCH ID <--");
		}
		
		mav2.setViewName("return_searchpage");
		return mav2;
	}
	@GetMapping("return_search")
	public String ruturnToSearchPage()
	{
		System.out.println("--> ruturnToSearchPage method");
		return "search_student";
	}


	}




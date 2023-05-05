package student.management;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

 public interface TeacherRepository extends JpaRepository<TeacherLoginEntity, Integer> {

	 @Query(value="select username from teacher_login where password=?1",nativeQuery=true)
	public TeacherLoginEntity toGetAllPassword(Integer password);
	 
}

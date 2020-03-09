package edu.mum.cs.cs425.registrationmgmt.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs425.registrationmgmt.model.Student;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {	
	
	private static final String SEARCH_STUDENTNUMBER_ENTRIES = "SELECT student_id, student_number FROM students t WHERE " +
	            "LOWER(t.student_number) LIKE LOWER(CONCAT('%',:searchTerm, '%')) ";
	private static final String SEARCH_STUDENT_ENTRIES = "SELECT * FROM students t WHERE " +
            "LOWER(t.student_number) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.last_name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.first_name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.middle_name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.cpga) LIKE LOWER(CONCAT('%',:searchTerm, '%')) " +
            "ORDER BY t.student_number ASC";
	 
    private final NamedParameterJdbcTemplate jdbcTemplate;
	 
    @Autowired
    CustomStudentRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
 
    @Transactional(readOnly = true)
    @Override
	public boolean findByStudentNumber(String value) {
    	Map<String, String> queryParams = new HashMap<>();
        queryParams.put("searchTerm", value);
 
        List<Student> searchResults = jdbcTemplate.query(SEARCH_STUDENTNUMBER_ENTRIES,
                queryParams,
                new BeanPropertyRowMapper<>(Student.class)
        );
        if(searchResults!=null) return true;	 
        return false;
	}

	@Override
	public List<Student> findBySearchTerm(String value) {
		Map<String, String> queryParams = new HashMap<>();
        queryParams.put("searchTerm", value);
 
        List<Student> searchResults = jdbcTemplate.query(SEARCH_STUDENT_ENTRIES,
                queryParams,
                new BeanPropertyRowMapper<>(Student.class)
        ); 
        return searchResults;
	}

}

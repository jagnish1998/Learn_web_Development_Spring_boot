package learn.springboot.udemy.second;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {
	RestTemplate template = new RestTemplate();
	
	@Autowired
	ServiceConfiguration serviceConfiguration;
	
	@GetMapping("/coures")
	public List<Course> getCourses(){
		return Arrays.asList(
				new Course(1, "one", 100),
				new Course(2, "two", 200)
				);
	}
	
	@GetMapping("/getEntity/{entityId}")
	public ResponseEntity<String> returnReltio(@PathVariable String entityId,@RequestHeader("Authorization") String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(accessToken);
		String url = "https://test-usg.reltio.com/reltio/api/Ru4RD0ycfRU4i0r/entities/"+entityId ;
		ResponseEntity<String>  response = template.exchange(url, HttpMethod.GET , new HttpEntity<>(headers),String.class);
		return ResponseEntity.ok(response.getBody());
	}
	
	
	@GetMapping("/getdetails")
	public ServiceConfiguration getDetails(){
		return serviceConfiguration;
	}
}

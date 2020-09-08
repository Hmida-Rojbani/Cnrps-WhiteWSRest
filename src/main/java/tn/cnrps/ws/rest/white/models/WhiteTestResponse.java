package tn.cnrps.ws.rest.white.models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WhiteTestResponse {
	
	private Student student;
	private Exam exam;
	private LocalDateTime date;
	private List<String> badRequests;

}

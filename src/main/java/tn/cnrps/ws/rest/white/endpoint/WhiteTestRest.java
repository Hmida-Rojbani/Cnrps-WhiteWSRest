package tn.cnrps.ws.rest.white.endpoint;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.cnrps.ws.rest.white.models.StudentRequest;
import tn.cnrps.ws.rest.white.models.WhiteTestResponse;
import tn.cnrps.ws.rest.white.services.WhiteService;

@RestController
public class WhiteTestRest {
	@Autowired
	private WhiteService service;
	
	@PostMapping("/api/whitetest/register")
	public WhiteTestResponse registerTest(@Valid @RequestBody StudentRequest request) {
		return service.register(request);
	}

}

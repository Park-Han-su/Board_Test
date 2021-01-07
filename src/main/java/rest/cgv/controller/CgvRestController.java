package rest.cgv.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.cgv.service.MovieChartService;
import rest.cgv.vo.MovieChart;

@RestController
@RequestMapping("/api")
public class CgvRestController {
	
	@Autowired
	MovieChartService movieChartService;
	
	@GetMapping("/cgv/movieChart")
	public List<MovieChart> movieChart() throws IOException{
		return movieChartService.getMoviceChart();
	}

}

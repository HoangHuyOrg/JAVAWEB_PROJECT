package com.javaweb.api;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.customexception.FieldRequiredException;
import com.javaweb.model.BuildingDTO;
import com.javaweb.model.BuildingRequestDTO;
import com.javaweb.model.ErrorResponseDTO;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.service.BuildingService;

//@RestController = @Controller + @ResponseBody
//@RequestMapping can be replaced with GetMapping or PostMapping depending on the RequestMethod.

//@Controller
@RestController
@PropertySource("classpath:application.properties")
public class NewAPI {
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private BuildingService buildingService;

	@Value("${dev.Duong}")
	private String data;

	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
			@RequestParam(name = "typeCode", required = false) List<String> typecode) {
		List<BuildingDTO> buildingDTOs = buildingService.findAll(params, typecode);
		System.out.println(buildingDTOs.size());
		return buildingDTOs;
	}
	
	@GetMapping(value = "/api/test")
	public List<BuildingEntity> get(@RequestBody Map<String, String> param) {
		List<BuildingEntity> buildingEntities = new ArrayList<BuildingEntity>();
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(1L);
		buildingEntity.setFloorArea(100L);
		buildingEntities.add(buildingEntity);
		return buildingEntities;
	}
	
	

	@PostMapping(value = "/api/building/")
	@Transactional
	public String createBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setName(buildingRequestDTO.getName());
		buildingEntity.setWard(buildingRequestDTO.getWard());
		buildingEntity.setStreet(buildingRequestDTO.getStreet());
		buildingEntity.setDistrictEntity(new DistrictEntity(buildingRequestDTO.getDistrictid()));
		entityManager.persist(buildingEntity);
		return "HUY";
	}

	@PutMapping(value = "/api/building/")
	@Transactional
	public String updateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(2L);
		buildingEntity.setName(buildingRequestDTO.getName());
		buildingEntity.setWard(buildingRequestDTO.getWard());
		buildingEntity.setStreet(buildingRequestDTO.getStreet());
		buildingEntity.setDistrictEntity(new DistrictEntity(buildingRequestDTO.getDistrictid()));
//		entityManager.persist(buildingEntity); ínsert
		entityManager.merge(buildingEntity);
		return "HUY";
	}

	@DeleteMapping(value = "/api/building/{id}")
	@Transactional
	public String deleteBuilding(@PathVariable Long id) {
		BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, id);
		entityManager.remove(buildingEntity);
		return "HUY";
	}
	/*
	 * @RequestMapping(value = "/api/building", method = RequestMethod.GET)
	 * 
	 * //chuyển đổi data từ server trả về cho client (JSON)
	 * 
	 * @ResponseBody public BuildingDTO getBuilding(@RequestParam(value = "name")
	 * String name,
	 * 
	 * @RequestParam(value = "numberOfBasement", required = false) Integer
	 * numberOfBasement,
	 * 
	 * @RequestParam(value = "ward", required = false) String ward,
	 * 
	 * @RequestParam(value = "street", required = false) String street) {
	 * 
	 * BuildingDTO b = new BuildingDTO(); b.setName(name);
	 * b.setNumberOfBasement(numberOfBasement); b.setStreet(street);
	 * b.setWard(ward); System.out.println(b); return b; }
	 **/

	/*
	 * @GetMapping("/api/building") // chuyển đổi data từ server trả về cho client
	 * (JSON) // @ResponseBody public Object getBuilding(@RequestParam(value =
	 * "name") String name,
	 * 
	 * @RequestParam(value = "numberOfBasement", required = false) Integer
	 * numberOfBasement,
	 * 
	 * @RequestParam(value = "ward", required = false) String ward,
	 * 
	 * @RequestParam(value = "street", required = false) String street) {
	 * 
	 * // try { // System.out.println(5/0); // } catch (Exception e) { //
	 * ErrorResponseDTO er = new ErrorResponseDTO(); // er.setError(e.getMessage());
	 * // List<String> details = new ArrayList<String>(); //
	 * details.add("Khong the chia cho 0"); // er.setDetial(details); // return er;
	 * // } // // BuildingDTO b1 = new BuildingDTO(); // b1.setName(name); //
	 * b1.setNumberOfBasement(numberOfBasement); // b1.setStreet(street); //
	 * b1.setWard(ward);
	 * 
	 * System.out.println(5/0); return null; }
	 * 
	 **/
	/*
	 * @GetMapping("/api/building") public Object getBuilding(@RequestBody
	 * BuildingDTO buildingDTO) { try { validate(buildingDTO); } catch (Exception e)
	 * { ErrorResponseDTO er = new ErrorResponseDTO(); er.setError(e.getMessage());
	 * List<String> details = new ArrayList<String>();
	 * details.add("Loi name hoac numberOfBasement"); er.setDetial(details); return
	 * er; }
	 * 
	 * return buildingDTO; }
	 * 
	 * 
	 * //Hàm kiểm tra dữ liệu public void validate(BuildingDTO buildingDTO) {
	 * if(buildingDTO.getName() == null || buildingDTO.getName().equals("") ||
	 * buildingDTO.getNumberOfBasement() == null) { throw new
	 * FieldRequiredException("Name or NumberOfBasement is null"); } }
	 * 
	 **/

	/*
	 * //@RequestParam
	 * 
	 * @RequestMapping(value = "/api/building", method = RequestMethod.POST) public
	 * void getBuilding(@RequestParam Map<String, String> params) {
	 * System.out.println("OK"); }
	 **/

	/*
	 * @RequestMapping(value = "/api/building", method = RequestMethod.POST) public
	 * void getBuilding(@RequestBody BuildingDTO buildingDTO) {
	 * System.out.println(buildingDTO); }
	 **/

	/*
	 * @DeleteMapping(value = "/api/building/{id}/{name}") public void
	 * deleteBuilding(@PathVariable Integer id, @PathVariable String name) {
	 * System.out.println(id + " " + name); }
	 **/
}
package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import admin.service.AdminProductService;
import jakarta.servlet.http.HttpSession;
import product.bean.Product;

@CrossOrigin
@RestController
@RequestMapping(path = "admin")
public class AdminController {
	@Autowired
	private AdminProductService adminProductService;

	// @GetMapping(path = "testGo")
	// public String testGo() {

	// int number = 1;
	// int number2 = 1;
	// int sum = number + number2;

	// String sumString = sum + "";

	// return sumString;
	// }

	@PostMapping(path = "productUpload")
	public void productUpload(@RequestParam("productDTO") String productDTOJson,
			@RequestParam("mainCategory") String mainCategory,
			@RequestParam("subCategory") String subCategory,
			@RequestParam(value = "imgFiles", required = false) List<MultipartFile> imgFilesList,
			HttpSession session) throws IOException {

		adminProductService.productUpload(productDTOJson, mainCategory, subCategory, imgFilesList, session);

	}

	@GetMapping(path = "getProductList", produces = "application/json;charset=UTF-8")
	public List<Product> getProductList() {
		List<Product> productList = adminProductService.getProductList();

		return productList;

	}

	@PostMapping(path = "productDelete")
	public void productUpload(@RequestParam("productId") String productId) {

		adminProductService.productDelete(productId);

	}

	@PostMapping(path = "productDeleteSelected")
	public void productDeleteSelected(@RequestParam("productId") String productId) {

		adminProductService.productDeleteSelected(productId);

	}

	@GetMapping(path = "getProductUpdateForm", produces = "application/json;charset=UTF-8")
	public Optional<Product> getProductList(@RequestParam String productId) {
		Optional<Product> productList = adminProductService.getProductList(productId);

		return productList;

	}

	@PostMapping(path = "productUpdateWithoutImage")
	public void productUpdateWithoutImage(@RequestParam("productDTO") String productDTOJson,
			@RequestParam("mainCategory") String mainCategory,
			@RequestParam("subCategory") String subCategory,
			@RequestParam("productId") String productId) throws JsonMappingException, JsonProcessingException {
		System.out.println("여기는 컨트롤러");
		System.out.println("productDTOJson: " + productDTOJson);
		System.out.println("mainCategory: " + mainCategory);
		System.out.println("subCategory: " + subCategory);
		System.out.println("productId: " + productId);

		adminProductService.productUpdateWithoutImage(productDTOJson, mainCategory, subCategory, productId);

	}

	@PostMapping(path = "productUpdateAllWithImage")
	public void productUpdateAllWithImage(@RequestParam("productDTO") String productDTOJson,
			@RequestParam("mainCategory") String mainCategory,
			@RequestParam("subCategory") String subCategory,
			@RequestParam("productId") String productId,
			@RequestParam(value = "imgFiles", required = false) List<MultipartFile> imgFilesList,
			HttpSession session) throws JsonMappingException, JsonProcessingException {
		System.out.println("여기는 컨트롤러");
		System.out.println("productDTOJson: " + productDTOJson);
		System.out.println("mainCategory: " + mainCategory);
		System.out.println("subCategory: " + subCategory);
		System.out.println("productId: " + productId);

		adminProductService.productUpdateAllWithImage(productDTOJson, mainCategory, subCategory, productId,
				imgFilesList, session);

	}
}
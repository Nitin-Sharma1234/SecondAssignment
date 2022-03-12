package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;

@RestController
@RequestMapping("/asset")
public class AssetController {
	
	@Autowired
	AssetService assetService;
	

	// For Adding new Asset .
	@PostMapping("/add")
	public String addAsset(@RequestBody Asset asset) {

		return assetService.addAsset(asset);

	}

	// For getting all the list of Asset.
	@GetMapping("/showall")
	public List<Asset> showAll() {

		return assetService.showAll();

	}

	// Delete the Asset on the basis of their name
	@GetMapping("/delete")
	public String deleteAsset(@RequestParam String name) {

		return assetService.deleteAsset(name);
	}

	// Update the Asset .
	@PostMapping("/update")
	public String updateAsset(@RequestBody Asset asset) {

		return assetService.updateAsset(asset);

	}

	// Assign the Asset on the basis of their name
	@GetMapping("/assign")
	public String assignAsset(@RequestParam String name) {

		return assetService.assignAsset(name);
	}

	// Recover the Asset on the basis of their name
	@GetMapping("/recover")
	public String recoverAsset(@RequestParam String name) {

		return assetService.recoverAsset(name);
	}


}

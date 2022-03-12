package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AssetDao;
import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Asset;
import com.example.demo.entity.Status;

@Service
public class AssetService {
	@Autowired
	AssetDao assetDao;
	@Autowired
	CategoryDao categoryDao;
	
	

	// Add new asset checking new asset on the basis of their Id(Name)
	public String addAsset(Asset asset) {
		try {
			System.out.println(asset.toString());
			// if the asset is already present inside database then return asset already exists.
			if (!assetDao.findById(asset.getName()).isEmpty()) {
				return "Asset already exists";
			}
			//i know i need to do mapping but due to less time and i need to learn mapping so i just used this. This is not the right way.
			if(categoryDao.countByName(asset.getCategory())<=0) {
				return "Category is not exists.";
			}
			asset.setAssignmentStatus(Status.Available); 
		    Date date = new Date();  
			asset.setPurchaseDate(date);
			assetDao.save(asset);
				return "Asset Successfully Added";
				
		} catch (Exception e) {
			System.out.println(e);
			return "Failed Something Went Wrong";
		}
	}
	// Update the Asset check Asset on the basis of their name.
	public String updateAsset(Asset asset) {
		try {
			// First check if the Asset is present in the database or it's a new Asset
			// If the Asset is new then return Asset doesn't exists
			if (assetDao.searchByName(asset.getName()) == null) {
				return "Asset Doesn't Exists";
			}
			if(categoryDao.countByName(asset.getCategory())<=0) {
				return "Category is not exists.";
			}
			// if Asset is present then i update the Asset on the basis of It's id .

			Asset a = assetDao.searchByName(asset.getName());
			asset.setName(a.getName());
			assetDao.save(asset);
			return "Asset Successfully Updated";

		} catch (Exception e) {
			System.out.println(e);
			return "Failed to update";
		}
	}

	// Delete asset on the basis of their name
	public String deleteAsset(String name) {
		try {
			Asset asset = assetDao.searchByName(name);
			System.out.println(asset);
			// check if the name is present in the database if not then return assest doesn't exists.
			if (asset == null) {
				return "Asset Doesn't Exists.";
			}
			if(asset.getAssignmentStatus().equals(Status.Assigned)) {
				return "Asset is assigned not able to delete.";
			}
			// delete the asset 
			assetDao.delete(asset);
			return "Asset Successfully Deleted";

		} catch (Exception e) {
			System.out.println(e);
			return "Failed";
		}
	}

	// Show list of all the Asset
	public List<Asset> showAll() {
		return assetDao.findAll();
	}

	
public String assignAsset(String name) {
	
	Asset asset = assetDao.searchByName(name);
	if(asset==null) {
		return "This asset is not present";
	}
	if(asset.getAssignmentStatus().equals(Status.Assigned)) {
		return "Asset already assigned";
	}
	asset.setAssignmentStatus(Status.Assigned);
	assetDao.save(asset);
	return "Asset assigned succefully";
}


public String recoverAsset(String name) {
	Asset asset = assetDao.searchByName(name);
	if(asset==null) {
		return "This asset is not present";
	}
	if(asset.getAssignmentStatus().equals(Status.Recovered)) {
		return "Asset already Recoverd";
	}
	asset.setAssignmentStatus(Status.Recovered);
	assetDao.save(asset);
	return "Asset Recovered succefully";
}
	
}

package com.zym.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zym.dao.CollectionMapper;
import com.zym.domain.Collection;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	private CollectionMapper collectiontMapper;

	public Collection selectCollectionbyCollectionid(int collectionid) {

		return collectiontMapper.selectByPrimaryKey(collectionid);
	}

	public boolean insertCollection(Collection collection) {
	
		int result = collectiontMapper.insertSelective(collection);
		if (result == 1) {
			return true;
		}
		return false;
	}


	public boolean updateCollection(Collection collection) {
		int result = collectiontMapper.updateByPrimaryKeySelective(collection);
		if (result == 1) {
			return true;
		}
		return false;
	}
	public boolean deleteCollection(int collectionid) {
		int result = collectiontMapper.deleteByPrimaryKey(collectionid);
		if (result == 1) {
			return true;
		}
		return false;
	}

	public List<Collection> selectCollectionlist() {
		return collectiontMapper.selectCollectionList();
	}


	public boolean userCollection(long userid, int lecturesid) {
		if (!isuserCollection( userid,  lecturesid)) {
			Collection collection = new Collection();
			collection.setUserid(userid);
			collection.setLecturesid(lecturesid);
			collection.setCollectiontime(new Date());
			collectiontMapper.insertSelective(collection);
			return true;
		}
		return false;
	}

	public boolean isuserCollection(long userid, int lecturesid) {
		if (collectiontMapper.selectCollectionByUseridAndLecturesid(userid, lecturesid) != null){
			return true;
		}
		return false;
	}

	public PageInfo<Collection> lecturesQuerylikebyuserid(Integer pageNo, Integer pageSize, long userid) {
	    pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	   PageHelper.startPage(pageNo, pageSize);
	    List<Collection> list = collectiontMapper.queryuserenrollByuserid(userid);
	   PageInfo<Collection> page = new PageInfo<Collection>(list);
	    return page;
	}

	public List<Collection> getCollectionByDate(Map<String, Object> map) {
		
		return collectiontMapper.getCollectionByDate(map);
	}
	
}
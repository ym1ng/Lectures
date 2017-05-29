package com.zym.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.zym.domain.Collection;

public interface CollectionService {
	List<Collection> selectCollectionlist();
	Collection selectCollectionbyCollectionid(int collectionid);
	boolean  insertCollection(Collection collection);
	boolean  updateCollection(Collection collection);
	boolean  deleteCollection(int collectionid);
	boolean  userCollection(long userid,int lecturesid);
	boolean  isuserCollection(long userid,int lecturesid);
	PageInfo<Collection> lecturesQuerylikebyuserid(Integer pageNo,Integer pageSize,long userid);
	List<Collection> getCollectionByDate(Map<String, Object> map);

}
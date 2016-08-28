package com.mobilize.core.data;

import com.mobilize.core.domain.value.UIDGenVO;

public interface UIDGenMapper {
	public UIDGenVO getUIDObjByType(String type);
	public int insertUIDObj(UIDGenVO uidGenVO);
	public int updateUIDObjById(UIDGenVO uidGenVO);
	public int deleteUIDObjByType(String type);
}

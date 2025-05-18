package com.data.session10.service.Bai6;

import com.data.session10.dao.Bai6.UploadDao;
import com.data.session10.model.Bai6.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImp implements UploadService {

    @Autowired
    private UploadDao uploadDao;

    @Override
    public void save(UploadFile uploadFile) {
        uploadDao.save(uploadFile);
    }
}

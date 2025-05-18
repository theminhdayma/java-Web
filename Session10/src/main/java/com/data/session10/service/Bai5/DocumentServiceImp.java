package com.data.session10.service.Bai5;

import com.data.session10.dao.Bai5.DocumentDao;
import com.data.session10.model.Bai5.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImp implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public void save(Document document) {
        documentDao.save(document);
    }
}

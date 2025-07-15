package com.mignon.spring.service.impl;


import com.mignon.spring.dao.FileDao;
import com.mignon.spring.entity.dto.FileDTO;
import com.mignon.spring.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author WWenHai
 * @desc: 实现
 * @date: 2025-07-08 10:05
 **/
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {


    private final FileDao fileDao;


    @Override
    public Boolean setFile(FileDTO fileDTO)
    {
        //省略 如是否有同名文件?路径是否不存在
        // 路径是否合法? 是否含有../?
        // 需要检测文件类型?MIME
        //存入数据? 最后更新数据库
        return fileDao.setFile(fileDTO.getName(),fileDTO.getPath());
    }
}

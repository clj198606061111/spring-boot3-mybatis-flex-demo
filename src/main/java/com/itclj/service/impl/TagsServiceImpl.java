package com.itclj.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.itclj.entity.Tags;
import com.itclj.mapper.TagsMapper;
import com.itclj.service.TagsService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author wujia
 * @since 2024-11-03
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {

}

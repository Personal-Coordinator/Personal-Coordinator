package com.example.personalcoordinator.service.defaultcourse;

import com.example.personalcoordinator.dto.defaultcourse.DefaultCourseResponseDto;
import com.example.personalcoordinator.mapper.DefaultCourseMapper;
import com.example.personalcoordinator.repository.DefaultCourseRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCourseServiceImpl implements DefaultCourseService {

    private final DefaultCourseRepository defaultCourseRepository;
    private final DefaultCourseMapper defaultCourseMapper;

    @Override
    public List<DefaultCourseResponseDto> getDefaultCourses() {
        return defaultCourseRepository.findAll().stream()
                .map(defaultCourseMapper::toDto)
                .toList();
    }
}

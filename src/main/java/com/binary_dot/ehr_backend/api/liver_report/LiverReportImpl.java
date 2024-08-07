package com.binary_dot.ehr_backend.api.liver_report;

import com.binary_dot.ehr_backend.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiverReportImpl implements LiverReportService{
    @Autowired
    private LiverReportRepository liverReportRepository;

    @Autowired
    private LiverReportMapper liverReportMapper;


    @Override
    public LiverReportDto addLiverReport(LiverReportDto liverReportDto) {
        if(liverReportDto == null) {
            return null;
        }
        LiverReport liverReport = liverReportRepository.save(liverReportMapper.mapToEntity(liverReportDto));
        return liverReportMapper.mapToDto(liverReport);
    }

    @Override
    public LiverReportDto findById(int id) throws NotFoundException {
        LiverReport liverReport = liverReportRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found LiverReport with Id " + id)
        );
        return liverReportMapper.mapToDto(liverReport);
    }

    @Override
    public List<LiverReportDto> findAll() {
        List<LiverReport> liverReports = liverReportRepository.findAll();
        return liverReports.stream().map(report -> liverReportMapper.mapToDto(report)).toList();
    }
}

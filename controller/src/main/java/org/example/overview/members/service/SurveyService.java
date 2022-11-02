package org.example.overview.members.service;

import org.example.overview.members.dao.MemberDAO;
import org.example.overview.members.dao.SurveyDAO;
import org.example.overview.members.dto.SurveyDTO;
import org.example.overview.members.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyService implements ISurveyService {

    private SurveyDAO surveyDAO; // = SurveyDAO.getInstance();
    private MemberDAO memberDAO; // = MemberDAO.getInstance();
//    private static SurveyService surveyService = null;

//    public static SurveyService getInstance() {
//        if (surveyService == null) {
//            surveyService = new SurveyService();
//        }
//        return surveyService;
//    }

    @Autowired
    public SurveyService(SurveyDAO surveyDAO, MemberDAO memberDAO) {
        this.surveyDAO = surveyDAO;
        this.memberDAO = memberDAO;
    }

    @Override
    public boolean save(String uId, String season, String fruit) {
        if (uId == null || season == null || fruit == null) return false;

        Survey survey = new Survey(uId, season, fruit);
        System.out.println(survey);
        int res = surveyDAO.insert(survey);
        return res > 0;
    }

    @Override
    public SurveyDTO getByUserId(String uId) {
        if (uId == null) return null;

        Survey survey = surveyDAO.select(uId);
        if (survey == null) return null;

        return survey.toDTO();
    }

    @Override
    public List<SurveyDTO> getAllUsers() {
        List<Survey> surveyList = surveyDAO.selectAll();

        return surveyList.stream().map(s -> s.toDTO()).collect(Collectors.toList());
    }

    @Override
    public boolean updateSeason(String uId, String season) {
        if (uId == null || season == null) return false;

        int res = surveyDAO.updateSeason(uId, season);
        return res > 0;
    }

    @Override
    public boolean updateFruit(String uId, String fruit) {
        if (uId == null || fruit == null) return false;

        int res = surveyDAO.updateFruit(uId, fruit);
        return res > 0;
    }

    @Override
    public boolean removeByUserId(String uId) {
        if (uId == null) return false;

        int res = surveyDAO.delete(uId);
        return res > 0;
    }

    @Override
    public boolean removeUsers() {
        int res = surveyDAO.deleteAll();
        return res > 0;
    }
}
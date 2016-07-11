package com.sandbox.gateway.web.resources;

import com.sandbox.business.domain.model.Question;
import com.sandbox.business.domain.model.Topic;
import com.sandbox.business.repository.IQuestionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by diogogallo on 7/11/16.
 */
@Path("/questions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class QuestionsResource {

    private IQuestionRepository questionRepository;

    @Inject
    public QuestionsResource(IQuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    /*
    Get all Questions
    return questions
     */
    @GET
    public List getAllQuestions(){
        List questions = this.questionRepository.findAll();
        return questions;
    }

    /**
     * Get single Question
     * @param id
     * @return question
     */
    @GET
    @Path("{id}")
    public Question getOneQuestion(@PathParam("id")long id) {
        Question question = questionRepository.findOne(id);
        if(question == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return question;
        }
    }

    /**
     * Create new Question
     * @param question
     * @return new question
     */
    @POST
    public Question insertNewQuestion(@Valid Question question) {
        return questionRepository.save(question);
    }

    /**
     * Update existing Question
     * @param id
     * @param question
     * @return updated question
     */
    @PUT
    @Path("{id}")
    public Question updateQuestion(@PathParam("id")long id, @Valid Question question) {
        if(questionRepository.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            question.setId(id);
            return questionRepository.save(question);
        }
    }

    /**
     * Delete question
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id) {
        Question question = questionRepository.findOne(id);
        if(question == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            questionRepository.delete(question);
        }
    }
}

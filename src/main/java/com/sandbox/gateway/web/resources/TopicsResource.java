package com.sandbox.gateway.web.resources;

import com.sandbox.business.domain.model.Topic;
import com.sandbox.business.repository.ITopicRepository;
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
@Path("/topics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class TopicsResource {

    private ITopicRepository topicRepository;

    @Inject
    public TopicsResource(ITopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    /*
    Get all Topics
    return topics
     */
    @GET
    public List getAllTopics(){
        List topics = this.topicRepository.findAll();
        return topics;
    }

    /**
     * Get single Topic
     * @param id
     * @return topic
     */
    @GET
    @Path("{id}")
    public Topic getOne(@PathParam("id")long id) {
        Topic topic = topicRepository.findOne(id);
        if(topic == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return topic;
        }
    }

    /**
     * Create new Topic
     * @param topic
     * @return new topic
     */
    @POST
    public Topic save(@Valid Topic topic) {
        return topicRepository.save(topic);
    }

    /**
     * Update existing Topic
     * @param id
     * @param topic
     * @return updated topic
     */
    @PUT
    @Path("{id}")
    public Topic update(@PathParam("id")long id, @Valid Topic topic) {
        if(topicRepository.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            topic.setId(id);
            return topicRepository.save(topic);
        }
    }

    /**
     * Delete topic
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id) {
        Topic topic = topicRepository.findOne(id);
        if(topic == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            topicRepository.delete(topic);
        }
    }

    @GET
    @Path("{id}/questions")
    public Topic getAllQuestionsForTopic(@PathParam("id")long id) {
        Topic topic = topicRepository.findOne(id);
        if (topic == null) {
            throw new WebApplicationException((Response.Status.NOT_FOUND));
        }

        topic.getQuestions().size();
        return topic;
    }
}

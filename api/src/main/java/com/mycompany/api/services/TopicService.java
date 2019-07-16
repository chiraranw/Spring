/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.api.services;

import com.mycompany.api.dao.TopicDAO;
import com.mycompany.api.model.Topic;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author chiraran
 */

@Service
public class TopicService implements TopicDAO {

    List<Topic> topics = Arrays.asList(new Topic(1, "NM", "IT"), new Topic(2, "LDSC", "IT"), new Topic(3, "COA", "IT"));

    @Override
    public Topic getTopic(int id) {
        Topic temp = null;
        for (Topic t : topics) {
            if (t.getId() == id) {
                temp = t;
            }
        }

        return temp;
    }

    @Override
    public void deleteTopic(int id) {
        System.out.println("Deleted topic: " + id);
    }

    @Override
    public void updateTopic(Topic topic) {
        System.out.println("update topic: " + topic);
    }

    @Override
    public List<Topic> getTopics() {
        return topics;
    }

    @Override
    public void addTopic(Topic t) {
        System.out.println("Added topic: "+t);
    }

}

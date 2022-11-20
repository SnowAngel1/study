package com.study.neo4j;

import com.study.neo4j.dao.PersonRelationShipRepository;
import com.study.neo4j.dao.PersonRepository;
import com.study.neo4j.dao.StarRelationRepository;
import com.study.neo4j.entity.Person;
import com.study.neo4j.entity.PersonRelationShip;
import com.study.neo4j.entity.StarRelation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

/**
 * @author：江南
 * @Description TODO
 * @since 1.0.0
 */
@SpringBootTest(classes = Neo4jSpringBootApplication.class)
public class Neo4jSpringBootApplicationTest {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonRelationShipRepository personRelationShipRepository;

    @Autowired
    private StarRelationRepository starRelationRepository;

    /**
     * 通过ID 获取一个节点
     */
    @Test
    public void getNode() {
        Optional<Person> byId = personRepository.findById(60L);
        byId.orElse(null);
    }

    /**
     * 通过ID 删除一个节点
     */
    @Test
    public void deleteNode() {
        personRepository.deleteById(60L);
    }

    /**
     * 创建一个节点
     */
    @Test
    public void createNode() {
        Person person = new Person();
        person.setName("小明");
        personRepository.save(person);
    }


    /**
     * 构建关系
     */
    @Test
    public void createNodeRelationShip() {

        Person person1 = new Person();
        person1.setName("杨戬");
        Person person2 = new Person();
        person2.setName("玉鼎真人");
        personRepository.save(person1);
        personRepository.save(person2);

        PersonRelationShip ship = new PersonRelationShip();
        ship.setParent(person2);
        ship.setChild(person1);
        ship.setRelation("师徒");
        personRelationShipRepository.save(ship);
    }

    /**
     * 直接使用语句，构建关系
     */
    @Test
    public void useSentenceCreateNodeRelationShip() {
        personRelationShipRepository.createNodeRelationShip("陈迎鹏","媳妇","张云铮");
    }


    /**
     * 直接使用语句，构建关系
     */
    @Test
    public void createStarRelationShip() {
        List<StarRelation> create = starRelationRepository.createStarRealtionByName("黄家强");
        System.out.println(create);
    }


    /**
     * 直接使用语句，查询关系
     */
    @Test
    public void queryStarRelationShip() {
        List<StarRelation> create = starRelationRepository.createStarRealtionByName("刘烨");
        for (StarRelation starRelation : create) {
            System.out.println(starRelation);
        }
    }


    /**
     * 直接使用语句，构建关系
     */
    @Test
    public void qyeryStarByName() {
        List<StarRelation> create = starRelationRepository.qyeryStarByName("刘烨");
        for (StarRelation starRelation : create) {
            System.out.println(starRelation);
        }
    }
}

    package com.interviewPrep.Project.entities;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;


    @Setter
    @Getter
    @Entity
    @Table(name="NetworkElement")
    public class NetworkElement {
        private int ip;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        private String hostname;
        private String location;

    }

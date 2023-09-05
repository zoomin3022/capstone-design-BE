package com.inha.capstonedesign.voting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inha.capstonedesign.image.entity.CandidateImage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name = "candidate_name")
    private String candidateName;

    @Column(name = "candidate_vote_count")
    private Integer candidateVoteCount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ballot_id")
    private Ballot ballot;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "candidate_image_id")
    private CandidateImage candidateImage;
}

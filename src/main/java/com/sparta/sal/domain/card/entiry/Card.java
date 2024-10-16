package com.sparta.sal.domain.card.entiry;

import com.sparta.sal.common.entity.Timestamped;
import com.sparta.sal.domain.assignee.entity.Assignee;
import com.sparta.sal.domain.card.dto.request.ModifyCardRequest;
import com.sparta.sal.domain.card.dto.request.SaveCardRequest;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "card")
public class Card extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardTitle;
    private String cardExplain;
    private LocalDateTime deadline;
    private String attachment;
    private boolean isDeleted=false;

    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE)
    private  List<Assignee> assignees = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = false)
    private com.sparta.sal.domain.list.entity.List list;

    public Card(SaveCardRequest reqDto){
        this.cardTitle = reqDto.getTitle();
        this.cardExplain= reqDto.getCardExplain();
        this.deadline = reqDto.getDeadline();
        this.attachment = reqDto.getAttachment();
    }

    public void modifyCard(ModifyCardRequest reqDto){
        this.cardTitle = reqDto.getTitle();
        this.cardExplain= reqDto.getCardExplain();
        this.deadline = reqDto.getDeadline();
        this.attachment = reqDto.getAttachment();
    }

    public void deleteCard(){
        this.isDeleted=true;
    }

    public void addList(com.sparta.sal.domain.list.entity.List list){
        this.list=list;
    }


}

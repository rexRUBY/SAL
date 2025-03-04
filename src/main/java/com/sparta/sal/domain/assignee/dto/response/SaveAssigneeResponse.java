package com.sparta.sal.domain.assignee.dto.response;

import com.sparta.sal.domain.assignee.entity.Assignee;
import lombok.Getter;

@Getter
public class SaveAssigneeResponse {
    private Long assigneeId;
    private Long cardId;
    private Long memberId;

    public SaveAssigneeResponse(Assignee assignee) {
        this.assigneeId = assignee.getId();
        this.cardId = assignee.getCard().getId();
        this.memberId = assignee.getMember().getId();
    }
}

package com.sparta.sal.domain.board.controller;

import com.sparta.sal.common.dto.AuthUser;
import com.sparta.sal.domain.board.dto.request.BoardRequestDto;
import com.sparta.sal.domain.board.dto.response.BoardResponseDto;
import com.sparta.sal.domain.board.dto.response.BoardSimpleResponseDto;
import com.sparta.sal.domain.board.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/workspaces")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/{workSpaceId}/boards")
    public ResponseEntity<BoardResponseDto> postBoard(@AuthenticationPrincipal AuthUser authUser,
                                                      @PathVariable Long workSpaceId,
                                                      @RequestBody BoardRequestDto boardRequestDto){
        return ResponseEntity.ok(boardService.postBoard(authUser,workSpaceId,boardRequestDto));
    }

    @PutMapping("/{workSpaceId}/boards/{boardId}")
    public ResponseEntity<BoardResponseDto> updateBoard(@AuthenticationPrincipal AuthUser authUser,
                                                        @PathVariable Long workSpaceId,
                                                        @PathVariable Long boardId,
                                                        @RequestBody BoardRequestDto boardRequestDto){
        return ResponseEntity.ok(boardService.updateBoard(authUser,workSpaceId,boardId,boardRequestDto));
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardSimpleResponseDto>> getBoard(@AuthenticationPrincipal AuthUser authUser){
        return ResponseEntity.ok(boardService.getBoard(authUser));
    }

    @DeleteMapping("/boards/{boardId}")
    public void deleteBoard(@AuthenticationPrincipal AuthUser authUser, @PathVariable Long boardId){
        boardService.deleteBoard(authUser,boardId);
    }
}

package maeng0830.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.time.LocalDate;
import java.util.List;
import maeng0830.weather.domain.Diary;
import maeng0830.weather.service.DiaryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @ApiOperation(value = "날씨 일기를 작성하는 API입니다.")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2022-10-25") LocalDate date,
        @RequestBody String text) {
        diaryService.createDiary(date, text);
    }

    @ApiOperation(value = "특정 날짜의 날씨 일기를 불러오는 API입니다.")
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2022-10-25") LocalDate date) {
        return diaryService.readDiary(date);
    }

    @ApiOperation(value = "특정 날짜 범위의 날씨일기를 모두 불러오는 API입니다.")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2022-10-24") LocalDate startDate,
        @RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2022-10-25") LocalDate endDate) {

        return diaryService.readDiaries(startDate, endDate);
    }

    @ApiOperation(value = "특정 날짜의 날씨일기를 수정하는 API입니다.")
    @PutMapping("update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2022-10-25") LocalDate date,
        @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @ApiOperation(value = "특정 날짜의 날씨일기를 삭제하는 API입니다.")
    @DeleteMapping("delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso = ISO.DATE) @ApiParam(value = "날짜 형식: yyyy-MM-dd", example = "2022-10-25") LocalDate date) {
        diaryService.deleteDiary(date);
    }
}

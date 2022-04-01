package com.wincom.dbsyncagent.tasks.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RdAlbumInfoDto {

    private String albumId;      //= 앨범 ID
    private String albumName;      //= 앨범명
    private String seriesDesc;
    private String onairDate;
    private String onairDateDisplay;
    private String releaseDate;
    private String runTime;
    private String prInfo;
    private String kidsGrade;
    private String country;
    private String directorDisplay;
    private String producer;
    private String starringActor;
    private String actorsDisplay;
    private String voiceActor;
    private String studio;
    private String player;
    private String castName;
    private String writer;
    private String genreLarge;
    private String genreMid;
    private String genreSmall;
    private String genre;
    private String category;
    private String introType;
    private String introduction;
    private String subTitle;
    private String dubbing;
    private String nscreenYn;
    private String cineId;
    private String highQualityType;
    private String watchPctvYn;
    private String watchRightYn;
    private String encodingFormat;
    private String genreType;
    private String vodType;
    private String musicContType;
    private String omniviewYn;
    private String concertLinkUrl;
    private String sysRegDt;
    private String sysRegId;
    private String sysModDt;
    private String sysModId;

}

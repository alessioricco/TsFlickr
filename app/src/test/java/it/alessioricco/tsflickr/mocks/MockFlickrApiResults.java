package it.alessioricco.tsflickr.mocks;

import com.google.gson.Gson;

import it.alessioricco.tsflickr.models.JsonFlickrFeed;
import lombok.Getter;

/**
 * fake results used for testing both with or without a fake web server
 */

public class MockFlickrApiResults {

    private static @Getter
    String rawJsonFlickrFeed = "\n"+
            "{\n"+
            "\t\t\"title\": \"Uploads from everyone\",\n"+
            "\t\t\"link\": \"https://www.flickr.com/photos/\",\n"+
            "\t\t\"description\": \"\",\n"+
            "\t\t\"modified\": \"2016-11-09T15:08:00Z\",\n"+
            "\t\t\"generator\": \"https://www.flickr.com/\",\n"+
            "\t\t\"items\": [\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"Slowly getting my Chiclines set. \uD83D\uDE04Finished Anya\\'s face up, but will definitely redo it. At least she has a face for this weekend\\'s meetup! Plz excuse nanuri on a ws body. His is in pieces being cleaned!\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/redmaiko/30243888543/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5466/30243888543_b9228b3c33_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T09:08:00-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/redmaiko/\\\">redmaiko<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/redmaiko/30243888543/\\\" title=\\\"Slowly getting my Chiclines set. \uD83D\uDE04Finished Anya\\'s face up, but will definitely redo it. At least she has a face for this weekend\\'s meetup! Plz excuse nanuri on a ws body. His is in pieces being cleaned!\\\"><img src=\\\"https://farm6.staticflickr.com/5466/30243888543_b9228b3c33_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"Slowly getting my Chiclines set. \uD83D\uDE04Finished Anya\\'s face up, but will definitely redo it. At least she has a face for this weekend\\'s meetup! Plz excuse nanuri on a ws body. His is in pieces being cleaned!\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:00Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (redmaiko)\",\n"+
            "\t\t\t\"author_id\": \"28373086@N07\",\n"+
            "\t\t\t\"tags\": \"instagramapp square squareformat iphoneography uploaded:by=instagram nashville\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"IMG_0080\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/136203500@N04/30243889463/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5464/30243889463_b14f5c8293_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-08T13:52:28-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/136203500@N04/\\\">devitoricky<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/136203500@N04/30243889463/\\\" title=\\\"IMG_0080\\\"><img src=\\\"https://farm6.staticflickr.com/5464/30243889463_b14f5c8293_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"IMG_0080\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:03Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (devitoricky)\",\n"+
            "\t\t\t\"author_id\": \"136203500@N04\",\n"+
            "\t\t\t\"tags\": \"\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"One sentence summarizes why #donaldtrump has won the #elections2016 : The silent majority stands with Trump #uselections #trump #usa #president #elections\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/94194745@N07/30243889833/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5736/30243889833_4cf80197d5_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T07:08:04-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/94194745@N07/\\\">azizdogdu<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/94194745@N07/30243889833/\\\" title=\\\"One sentence summarizes why #donaldtrump has won the #elections2016 : The silent majority stands with Trump #uselections #trump #usa #president #elections\\\"><img src=\\\"https://farm6.staticflickr.com/5736/30243889833_4cf80197d5_m.jpg\\\" width=\\\"240\\\" height=\\\"149\\\" alt=\\\"One sentence summarizes why #donaldtrump has won the #elections2016 : The silent majority stands with Trump #uselections #trump #usa #president #elections\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:04Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (azizdogdu)\",\n"+
            "\t\t\t\"author_id\": \"94194745@N07\",\n"+
            "\t\t\t\"tags\": \"instagramapp square squareformat iphoneography uploaded:by=instagram\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"R0012624\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/11175207@N07/30247308674/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5583/30247308674_8aa38f4f62_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-06T13:23:31-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/11175207@N07/\\\">drcsj<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/11175207@N07/30247308674/\\\" title=\\\"R0012624\\\"><img src=\\\"https://farm6.staticflickr.com/5583/30247308674_8aa38f4f62_m.jpg\\\" width=\\\"240\\\" height=\\\"159\\\" alt=\\\"R0012624\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:07:59Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (drcsj)\",\n"+
            "\t\t\t\"author_id\": \"11175207@N07\",\n"+
            "\t\t\t\"tags\": \"gr\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"Robot & Box, a portrait ...\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/btripp/30247309504/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5738/30247309504_7da0869096_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T09:08:01-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/btripp/\\\">BrendanTripp<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/btripp/30247309504/\\\" title=\\\"Robot &amp; Box, a portrait ...\\\"><img src=\\\"https://farm6.staticflickr.com/5738/30247309504_7da0869096_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"Robot &amp; Box, a portrait ...\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:01Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (BrendanTripp)\",\n"+
            "\t\t\t\"author_id\": \"52968162@N02\",\n"+
            "\t\t\t\"tags\": \"instagramapp square squareformat iphoneography uploaded:by=instagram\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"20160705-01465.jpg\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/141881544@N03/30247310454/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5806/30247310454_f265b6b368_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-07-05T15:26:59-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/141881544@N03/\\\">zennokyrie<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/141881544@N03/30247310454/\\\" title=\\\"20160705-01465.jpg\\\"><img src=\\\"https://farm6.staticflickr.com/5806/30247310454_f265b6b368_m.jpg\\\" width=\\\"159\\\" height=\\\"240\\\" alt=\\\"20160705-01465.jpg\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:04Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (zennokyrie)\",\n"+
            "\t\t\t\"author_id\": \"141881544@N03\",\n"+
            "\t\t\t\"tags\": \"\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"Bruges ville à 30 km-h 23\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/alainrouiller/30247310934/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5582/30247310934_d9619cc787_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-05-16T17:15:22-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/alainrouiller/\\\">rouilleralain<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/alainrouiller/30247310934/\\\" title=\\\"Bruges ville à 30 km-h 23\\\"><img src=\\\"https://farm6.staticflickr.com/5582/30247310934_d9619cc787_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"Bruges ville à 30 km-h 23\\\" /><\\/a><\\/p> <p>La totalité du centre-ville est à 30 km/h, quelques collectrices à 50 km/h subsistent dans les quartiers extérieurs. La route de ceinture est à 70 km/h<\\/p>\",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:05Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (rouilleralain)\",\n"+
            "\t\t\t\"author_id\": \"63127193@N06\",\n"+
            "\t\t\t\"tags\": \"zone30\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"DSC01692\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/149083908@N08/30247311304/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5540/30247311304_a5aa6be397_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2013-01-11T13:28:54-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/149083908@N08/\\\">mppm2002<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/149083908@N08/30247311304/\\\" title=\\\"DSC01692\\\"><img src=\\\"https://farm6.staticflickr.com/5540/30247311304_a5aa6be397_m.jpg\\\" width=\\\"240\\\" height=\\\"180\\\" alt=\\\"DSC01692\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:06Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (mppm2002)\",\n"+
            "\t\t\t\"author_id\": \"149083908@N08\",\n"+
            "\t\t\t\"tags\": \"\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"upload\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/148881259@N08/30578158810/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5483/30578158810_fe2308dbb9_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T07:08:02-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/148881259@N08/\\\">gardene74<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/148881259@N08/30578158810/\\\" title=\\\"upload\\\"><img src=\\\"https://farm6.staticflickr.com/5483/30578158810_fe2308dbb9_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"upload\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:02Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (gardene74)\",\n"+
            "\t\t\t\"author_id\": \"148881259@N08\",\n"+
            "\t\t\t\"tags\": \"instagramapp square squareformat iphoneography uploaded:by=instagram\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"Many thanks to MIT student Shivangi Goel from Save a Life, Save a Heart who taught us how to do #CPR, recognize signs of #stroke, and do a #Heimlich maneuver! #MITservice #MITstudents ______________ #kindness #givingback #communityengagement #communityser\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/mitpsc/30763061092/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5821/30763061092_c63e890628_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T10:08:03-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/mitpsc/\\\">MIT Priscilla King Gray Public Service Center<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/mitpsc/30763061092/\\\" title=\\\"Many thanks to MIT student Shivangi Goel from Save a Life, Save a Heart who taught us how to do #CPR, recognize signs of #stroke, and do a #Heimlich maneuver! #MITservice #MITstudents ______________ #kindness #givingback #communityengagement #communityser\\\"><img src=\\\"https://farm6.staticflickr.com/5821/30763061092_c63e890628_m.jpg\\\" width=\\\"240\\\" height=\\\"240\\\" alt=\\\"Many thanks to MIT student Shivangi Goel from Save a Life, Save a Heart who taught us how to do #CPR, recognize signs of #stroke, and do a #Heimlich maneuver! #MITservice #MITstudents ______________ #kindness #givingback #communityengagement #communityser\\\" /><\\/a><\\/p> <p>via Instagram <a href=\\\"https://www.instagram.com/p/BMmAboRAr_5/\\\" rel=\\\"nofollow\\\">www.instagram.com/p/BMmAboRAr_5/<\\/a><\\/p>\",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:03Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (MIT Priscilla King Gray Public Service Center)\",\n"+
            "\t\t\t\"author_id\": \"91862932@N06\",\n"+
            "\t\t\t\"tags\": \"ifttt instagram\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"olson kundig embeds corten residence next to cliff edge https://t.co/4DkvhOv1tX\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/140134064@N07/30763061772/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5642/30763061772_8b6b45f01f_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T07:08:05-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/140134064@N07/\\\">kevin paige<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/140134064@N07/30763061772/\\\" title=\\\"olson kundig embeds corten residence next to cliff edge https://t.co/4DkvhOv1tX\\\"><img src=\\\"https://farm6.staticflickr.com/5642/30763061772_8b6b45f01f_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"olson kundig embeds corten residence next to cliff edge https://t.co/4DkvhOv1tX\\\" /><\\/a><\\/p> <p>(via Twitter <a href=\\\"http://twitter.com/PaigeStainless/status/796368153097961473\\\" rel=\\\"nofollow\\\">twitter.com/PaigeStainless/status/796368153097961473<\\/a>)<\\/p>\",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:05Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (kevin paige)\",\n"+
            "\t\t\t\"author_id\": \"140134064@N07\",\n"+
            "\t\t\t\"tags\": \"shower bathroom drains grates stainless steel fabrication\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"CathayPacific_B-LAL\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/billlmf_vhhh/30763061832/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5571/30763061832_de416874d9_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T17:14:44-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/billlmf_vhhh/\\\">billlmf<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/billlmf_vhhh/30763061832/\\\" title=\\\"CathayPacific_B-LAL\\\"><img src=\\\"https://farm6.staticflickr.com/5571/30763061832_de416874d9_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"CathayPacific_B-LAL\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:05Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (billlmf)\",\n"+
            "\t\t\t\"author_id\": \"31943879@N03\",\n"+
            "\t\t\t\"tags\": \"\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"Pathway\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/mikeilchenko/30790782371/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5562/30790782371_1785c6e8f6_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-06T12:16:01-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/mikeilchenko/\\\">mike.ilchenko<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/mikeilchenko/30790782371/\\\" title=\\\"Pathway\\\"><img src=\\\"https://farm6.staticflickr.com/5562/30790782371_1785c6e8f6_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"Pathway\\\" /><\\/a><\\/p> <p>Pathway<\\/p>\",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:01Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (mike.ilchenko)\",\n"+
            "\t\t\t\"author_id\": \"62418399@N03\",\n"+
            "\t\t\t\"tags\": \"kislovodsk stavropolskiykray russia ru\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \" \",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/148880814@N02/30790782761/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5780/30790782761_c2907364a5_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-08-14T13:43:23-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/148880814@N02/\\\">АннаКоварская<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/148880814@N02/30790782761/\\\" title=\\\" \\\"><img src=\\\"https://farm6.staticflickr.com/5780/30790782761_c2907364a5_m.jpg\\\" width=\\\"180\\\" height=\\\"240\\\" alt=\\\" \\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:03Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (АннаКоварская)\",\n"+
            "\t\t\t\"author_id\": \"148880814@N02\",\n"+
            "\t\t\t\"tags\": \"\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"Sydney 2016 Nov 10 02:08\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/ccrc_weather/30790782951/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5781/30790782951_543eacff6f_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-10T02:07:49-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/ccrc_weather/\\\">ccrc_weather<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/ccrc_weather/30790782951/\\\" title=\\\"Sydney 2016 Nov 10 02:08\\\"><img src=\\\"https://farm6.staticflickr.com/5781/30790782951_543eacff6f_m.jpg\\\" width=\\\"240\\\" height=\\\"180\\\" alt=\\\"Sydney 2016 Nov 10 02:08\\\" /><\\/a><\\/p> <p>View of Sydney shot from a weather station on top of the Mathews building at the University of New South Wales, Kensington. Shot taken by the Climate Change Research Centre (<a href=\\\"http://ccrc.unsw.edu.au\\\" rel=\\\"nofollow\\\">ccrc.unsw.edu.au<\\/a>) at 2016 Nov 10 02:08.<\\/p>\",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:04Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (ccrc_weather)\",\n"+
            "\t\t\t\"author_id\": \"132153736@N04\",\n"+
            "\t\t\t\"tags\": \"ccrcweather weatherstation aws unsw kensington sydney australia automatic outdoor sky 2016 nov night\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"1DX13435.jpg\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/alanmcbride/30790783541/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5641/30790783541_269d95e39f_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-09T11:01:04-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/alanmcbride/\\\">alanmcbride1<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/alanmcbride/30790783541/\\\" title=\\\"1DX13435.jpg\\\"><img src=\\\"https://farm6.staticflickr.com/5641/30790783541_269d95e39f_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"1DX13435.jpg\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:06Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (alanmcbride1)\",\n"+
            "\t\t\t\"author_id\": \"58331999@N02\",\n"+
            "\t\t\t\"tags\": \"bird birds littleegret france occitanie gruissan languedoc aude\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"ACT2-P-006.jpg\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/146323421@N04/30790783741/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5734/30790783741_a2dcac5af5_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-10T01:45:57-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/146323421@N04/\\\">Sydney City Ballet School<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/146323421@N04/30790783741/\\\" title=\\\"ACT2-P-006.jpg\\\"><img src=\\\"https://farm6.staticflickr.com/5734/30790783741_a2dcac5af5_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"ACT2-P-006.jpg\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:07Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (Sydney City Ballet School)\",\n"+
            "\t\t\t\"author_id\": \"146323421@N04\",\n"+
            "\t\t\t\"tags\": \"\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"чайки 458\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/fbiskievua/30843085076/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5535/30843085076_3517db7db0_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-06-07T14:17:42-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/fbiskievua/\\\">fbis.kiev.ua<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/fbiskievua/30843085076/\\\" title=\\\"чайки 458\\\"><img src=\\\"https://farm6.staticflickr.com/5535/30843085076_3517db7db0_m.jpg\\\" width=\\\"240\\\" height=\\\"160\\\" alt=\\\"чайки 458\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:02Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (fbis.kiev.ua)\",\n"+
            "\t\t\t\"author_id\": \"127500397@N02\",\n"+
            "\t\t\t\"tags\": \"чайки\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"Across the Bay 10k with Team HoganStrong\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/mdgovpics/30879362495/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5772/30879362495_703529bd57_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-11-06T00:00:00-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/mdgovpics/\\\">MDGovpics<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/mdgovpics/30879362495/\\\" title=\\\"Across the Bay 10k with Team HoganStrong\\\"><img src=\\\"https://farm6.staticflickr.com/5772/30879362495_703529bd57_m.jpg\\\" width=\\\"240\\\" height=\\\"192\\\" alt=\\\"Across the Bay 10k with Team HoganStrong\\\" /><\\/a><\\/p> <p>Governor Does The 10k With Team #HoganStrong by Steve Kwak at Chesapeake Bay Bridge, Maryland<\\/p>\",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:01Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (MDGovpics)\",\n"+
            "\t\t\t\"author_id\": \"64018555@N03\",\n"+
            "\t\t\t\"tags\": \"governorgovernorlawrencejhogan jrlarryhogangovernorhogangovernorlarryhogangovernorhogan\"\n"+
            "\t   },\n"+
            "\t   {\n"+
            "\t\t\t\"title\": \"_DSC3401_2016_06_11_2028_Nikon_D7000-HDR-Pano.jpg\",\n"+
            "\t\t\t\"link\": \"https://www.flickr.com/photos/thingymebobs/30879362825/\",\n"+
            "\t\t\t\"media\": {\"m\":\"https://farm6.staticflickr.com/5583/30879362825_2a6ce09ca8_m.jpg\"},\n"+
            "\t\t\t\"date_taken\": \"2016-06-11T20:32:51-08:00\",\n"+
            "\t\t\t\"description\": \" <p><a href=\\\"https://www.flickr.com/people/thingymebobs/\\\">ThingyMeBobs<\\/a> posted a photo:<\\/p> <p><a href=\\\"https://www.flickr.com/photos/thingymebobs/30879362825/\\\" title=\\\"_DSC3401_2016_06_11_2028_Nikon_D7000-HDR-Pano.jpg\\\"><img src=\\\"https://farm6.staticflickr.com/5583/30879362825_2a6ce09ca8_m.jpg\\\" width=\\\"240\\\" height=\\\"68\\\" alt=\\\"_DSC3401_2016_06_11_2028_Nikon_D7000-HDR-Pano.jpg\\\" /><\\/a><\\/p> \",\n"+
            "\t\t\t\"published\": \"2016-11-09T15:08:02Z\",\n"+
            "\t\t\t\"author\": \"nobody@flickr.com (ThingyMeBobs)\",\n"+
            "\t\t\t\"author_id\": \"84427104@N05\",\n"+
            "\t\t\t\"tags\": \"nikond7000 summer england themalvernhills panorama landscape themalverns when 1116tokina hills clouds\"\n"+
            "\t   }\n"+
            "        ]\n"+
            "}";


    /**
     * return a Model built on a given raw string
     * @param rawJsonFeed
     * @return
     */
    public static JsonFlickrFeed getJsonFlickrFeedAsModel(final String rawJsonFeed) {
        return new Gson().fromJson(rawJsonFeed, JsonFlickrFeed.class);
    }

    /**
     * return a Model built on the raw string
     * @return
     */
    public static JsonFlickrFeed getJsonFlickrFeedAsModel() {
        return getJsonFlickrFeedAsModel(rawJsonFlickrFeed);
    }
}

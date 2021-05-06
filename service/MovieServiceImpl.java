package org.spring.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;

@Service
public class MovieServiceImpl implements MovieService{
	private static final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Override
	public List<Map<String, String>> movieParse(String targetDt, String multiMovieYn, String repNationCd) throws OpenAPIFault, Exception  {
		//반환값
		List<Map<String, String>> rList = new ArrayList<>();
		
		String key = "91e071579c21875175ca4331c6b1cd24"; //발급받은키
		//String targetDt="20210216"; //조회하고자 하는 날짜
		targetDt = targetDt.replaceAll("-", ""); //문자열 치환
		String itemPerPage="10"; //결과 ROW 의 개수
		//String multiMovieYn="";//“Y” : 다양성 영화 “N” : 상업영화 (default : 전체)
		//String repNationCd="K"; //“K: : 한국영화 “F” : 외국영화 (default : 전체)
		String wideAreaCd=""; //지역코드

		KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
		
		String data = service.getDailyBoxOffice(true, targetDt,itemPerPage,multiMovieYn,repNationCd,wideAreaCd);
		System.out.println(data);
			
		//json파싱 : json-simple-1.1.1.jar 라이브러리 추가
		//String data="{\"boxOfficeResult\":{\"boxofficeType\":\"일별 박스오피스\",\"showRange\":\"20120101~20120101\",\"dailyBoxOfficeList\":[{\"rnum\":\"1\",\"rank\":\"1\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20112207\",\"movieNm\":\"미션임파서블:고스트프로토콜\",\"openDt\":\"2011-12-15\",\"salesAmt\":\"2776060500\",\"salesShare\":\"36.3\",\"salesInten\":\"-415699000\",\"salesChange\":\"-13\",\"salesAcc\":\"40541108500\",\"audiCnt\":\"353274\",\"audiInten\":\"-60106\",\"audiChange\":\"-14.5\",\"audiAcc\":\"5328435\",\"scrnCnt\":\"697\",\"showCnt\":\"3223\"},{\"rnum\":\"2\",\"rank\":\"2\",\"rankInten\":\"1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20110295\",\"movieNm\":\"마이 웨이\",\"openDt\":\"2011-12-21\",\"salesAmt\":\"1189058500\",\"salesShare\":\"15.6\",\"salesInten\":\"-105894500\",\"salesChange\":\"-8.2\",\"salesAcc\":\"13002897500\",\"audiCnt\":\"153501\",\"audiInten\":\"-16465\",\"audiChange\":\"-9.7\",\"audiAcc\":\"1739543\",\"scrnCnt\":\"588\",\"showCnt\":\"2321\"},{\"rnum\":\"3\",\"rank\":\"3\",\"rankInten\":\"-1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20112621\",\"movieNm\":\"셜록홈즈 : 그림자 게임\",\"openDt\":\"2011-12-21\",\"salesAmt\":\"1176022500\",\"salesShare\":\"15.4\",\"salesInten\":\"-210328500\",\"salesChange\":\"-15.2\",\"salesAcc\":\"10678327500\",\"audiCnt\":\"153004\",\"audiInten\":\"-31283\",\"audiChange\":\"-17\",\"audiAcc\":\"1442861\",\"scrnCnt\":\"360\",\"showCnt\":\"1832\"},{\"rnum\":\"4\",\"rank\":\"4\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20113260\",\"movieNm\":\"퍼펙트 게임\",\"openDt\":\"2011-12-21\",\"salesAmt\":\"644532000\",\"salesShare\":\"8.4\",\"salesInten\":\"-75116500\",\"salesChange\":\"-10.4\",\"salesAcc\":\"6640940000\",\"audiCnt\":\"83644\",\"audiInten\":\"-12225\",\"audiChange\":\"-12.8\",\"audiAcc\":\"895416\",\"scrnCnt\":\"396\",\"showCnt\":\"1364\"},{\"rnum\":\"5\",\"rank\":\"5\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20113271\",\"movieNm\":\"프렌즈: 몬스터섬의비밀 \",\"openDt\":\"2011-12-29\",\"salesAmt\":\"436753500\",\"salesShare\":\"5.7\",\"salesInten\":\"-89051000\",\"salesChange\":\"-16.9\",\"salesAcc\":\"1523037000\",\"audiCnt\":\"55092\",\"audiInten\":\"-15568\",\"audiChange\":\"-22\",\"audiAcc\":\"202909\",\"scrnCnt\":\"290\",\"showCnt\":\"838\"},{\"rnum\":\"6\",\"rank\":\"6\",\"rankInten\":\"1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"19940256\",\"movieNm\":\"라이온 킹\",\"openDt\":\"1994-07-02\",\"salesAmt\":\"507115500\",\"salesShare\":\"6.6\",\"salesInten\":\"-114593500\",\"salesChange\":\"-18.4\",\"salesAcc\":\"1841625000\",\"audiCnt\":\"45750\",\"audiInten\":\"-11699\",\"audiChange\":\"-20.4\",\"audiAcc\":\"171285\",\"scrnCnt\":\"244\",\"showCnt\":\"895\"},{\"rnum\":\"7\",\"rank\":\"7\",\"rankInten\":\"-1\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20113381\",\"movieNm\":\"오싹한 연애\",\"openDt\":\"2011-12-01\",\"salesAmt\":\"344871000\",\"salesShare\":\"4.5\",\"salesInten\":\"-107005500\",\"salesChange\":\"-23.7\",\"salesAcc\":\"20634684500\",\"audiCnt\":\"45062\",\"audiInten\":\"-15926\",\"audiChange\":\"-26.1\",\"audiAcc\":\"2823060\",\"scrnCnt\":\"243\",\"showCnt\":\"839\"},{\"rnum\":\"8\",\"rank\":\"8\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20112709\",\"movieNm\":\"극장판 포켓몬스터 베스트 위시「비크티니와 백의 영웅 레시라무」\",\"openDt\":\"2011-12-22\",\"salesAmt\":\"167809500\",\"salesShare\":\"2.2\",\"salesInten\":\"-45900500\",\"salesChange\":\"-21.5\",\"salesAcc\":\"1897120000\",\"audiCnt\":\"24202\",\"audiInten\":\"-7756\",\"audiChange\":\"-24.3\",\"audiAcc\":\"285959\",\"scrnCnt\":\"186\",\"showCnt\":\"348\"},{\"rnum\":\"9\",\"rank\":\"9\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20113311\",\"movieNm\":\"앨빈과 슈퍼밴드3\",\"openDt\":\"2011-12-15\",\"salesAmt\":\"137030000\",\"salesShare\":\"1.8\",\"salesInten\":\"-35408000\",\"salesChange\":\"-20.5\",\"salesAcc\":\"3416675000\",\"audiCnt\":\"19729\",\"audiInten\":\"-6461\",\"audiChange\":\"-24.7\",\"audiAcc\":\"516289\",\"scrnCnt\":\"169\",\"showCnt\":\"359\"},{\"rnum\":\"10\",\"rank\":\"10\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20112708\",\"movieNm\":\"극장판 포켓몬스터 베스트 위시 「비크티니와 흑의 영웅 제크로무」\",\"openDt\":\"2011-12-22\",\"salesAmt\":\"125535500\",\"salesShare\":\"1.6\",\"salesInten\":\"-40756000\",\"salesChange\":\"-24.5\",\"salesAcc\":\"1595695000\",\"audiCnt\":\"17817\",\"audiInten\":\"-6554\",\"audiChange\":\"-26.9\",\"audiAcc\":\"235070\",\"scrnCnt\":\"175\",\"showCnt\":\"291\"}]}}";
			  
		  JSONObject object = (JSONObject) new JSONParser().parse(data); //
		  System.out.println(object);
		  
		  object = (JSONObject) object.get("boxOfficeResult"); //
		  System.out.println(object);
		  
		  String value = (String)object.get("boxofficeType"); //제목
		  System.out.println(value); value = (String)object.get("showRange"); //기간
		  System.out.println(value);
		  
		  JSONArray array = (JSONArray)object.get("dailyBoxOfficeList"); //
		  System.out.println(array); 
		  for(int i=0; i<array.size(); i++) {
			  //한건을 저장하기위한 맵생성
			  Map<String,String> map = new HashMap<>();
			  object =  (JSONObject)array.get(i); // System.out.println(object); 
			  
			  value =  (String)object.get("rnum"); //순위
			  System.out.print(value+" ");
			  map.put("rnum", value);
			  
			  value = (String)object.get("audiCnt"); //해당일의 관객수 
			  System.out.print(value+" "); 
			  map.put("audiCnt", value);
			  
			  value  = (String)object.get("salesAcc"); //누적매출액 
			  System.out.print(value+" ");
			  map.put("salesAcc", value);
			  
			  value  = (String)object.get("scrnCnt"); //해당일자에 상영한 스크린수
			  System.out.print(value+" "); 
			  map.put("scrnCnt", value);
			  
			  value = (String)object.get("rankInten"); //전일대비 순위의 증감분 
			  System.out.print(value+" "); 
			  map.put("rankInten", value);
			  
			  value = (String)object.get("salesShare"); //해당일자 상영작의 매출총액 대비 해당 영화의 매출비율
			  System.out.print(value+" "); 
			  map.put("salesShare", value);
			  
			  value = (String)object.get("movieNm"); //영화명(국문)
			  System.out.print(value+" "); 
			  map.put("movieNm", value);
			  
			  value = (String)object.get("salesAmt"); //해당일의 매출액 
			  System.out.print(value+" "); 
			  map.put("salesAmt", value);
			  
			  value = (String)object.get("movieCd"); //영화의 대표코드 
			  System.out.print(value+" "); 
			  map.put("movieCd", value);
			  
			  value = (String)object.get("salesChange"); //전일 대비 매출액 증감 비율 
			  System.out.print(value+" ");
			  map.put("salesChange", value);
			  
			  value = (String)object.get("audiInten"); //전일 대비 관객수 증감분 
			  System.out.print(value+" ");
			  map.put("audiInten", value);
			  
			  value = (String)object.get("audiChange"); //전일 대비 관객수 증감 비율
			  System.out.print(value+" ");
			  map.put("audiChange", value);
			  
			  value = (String)object.get("rankOldAndNew"); //랭킹에 신규진입여부(“OLD” : 기존 , “NEW” : 신규) 
			  System.out.print(value+" "); 
			  map.put("rankOldAndNew", value);
			  
			  value = (String)object.get("rank"); //해당일자의 박스오피스 순위 
			  System.out.print(value+" ");
			  map.put("rank", value);
			  
			  value = (String)object.get("openDt"); //영화의 개봉일 
			  System.out.print(value+" ");
			  map.put("openDt", value);
			  
			  value = (String)object.get("salesInten"); //전일 대비 매출액 증감분
			  System.out.print(value+" ");
			  map.put("salesInten", value);
			  
			  value = (String)object.get("showCnt"); //해당일자에 상영된 횟수 
			  System.out.print(value+" "); 
			  map.put("showCnt", value);
			  
			  value = (String)object.get("audiAcc"); //누적관객수 
			  System.out.println(value);
			  map.put("audiAcc", value);
		  
			  //리스트에 맵 추가
			  rList.add(map);
		  }

		logger.info(rList.toString());
		
		return rList;
	}


	

}

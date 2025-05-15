package com.gyshop.util.movie;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.gyshop.movie.vo.MovieVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MovieInfoXML {

	public static String getMovieInfoXML(List<MovieVO> list) {
		
		HttpURLConnection con = null;
		String err = null;
		String key = "8587a970816e9487ea6d5205da108798";
		
		try {
			
			LocalDateTime dateTime = LocalDateTime.now();
			String year = "" + dateTime.getYear();
			
			URL url = new URL(""
					+ "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.xml"
					+ "?key=" + key
					+ "&itemPerPage=100"
					+ "&openStartDt=" + year);
			log.info("url : " + url);
			
			con = (HttpURLConnection) url.openConnection();
			log.info(con);
			
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(con.getInputStream());

			boolean ok = false;
			Element e;
			NodeList ns = doc.getElementsByTagName("movie");
			if (ns != null && ns.getLength()>0) {
				log.info("ok, length: " + ns.getLength());
				log.info(ns);
				ok = true;
			}
			else {
				e = (Element) doc.getElementsByTagName("faultInfo").item(0);
				err = e.getElementsByTagName("message").item(0).getTextContent();
				log.info("not");
				log.info(err);
			}
			
			if (ok) {
				ns = doc.getElementsByTagName("movie");
				for (int i = 0; i< ns.getLength() ; i++) {
					MovieVO vo = new MovieVO();
				//	log.info(i);
					e = (Element) ns.item(i);
				//	log.info(i);
					
					String str = e.getElementsByTagName("repGenreNm").item(0).getTextContent();
					
					if (str.equals("성인물(에로)")) continue;
					
					str = e.getElementsByTagName("movieCd").item(0).getTextContent();
					if (str != null) vo.setMovieCd(str);
					str = e.getElementsByTagName("movieNm").item(0).getTextContent();
					if (str != null) vo.setMovieNm(str);
					str = e.getElementsByTagName("movieNmEn").item(0).getTextContent();
					if (str != null) vo.setMovieNmEn(str);
					str = e.getElementsByTagName("openDt").item(0).getTextContent();
					if (str != null) vo.setOpenDt(str);
					str = e.getElementsByTagName("typeNm").item(0).getTextContent();
					if (str != null) vo.setTypeNm(str);
					str = e.getElementsByTagName("prdtStatNm").item(0).getTextContent();
					if (str != null) vo.setPrdtStatNm(str);
					str = e.getElementsByTagName("repNationNm").item(0).getTextContent();
					if (str != null) vo.setRepNationNm(str);
					str = e.getElementsByTagName("repGenreNm").item(0).getTextContent();
					if (str != null) vo.setRepGenreNm(str);
					if (e.getElementsByTagName("peopleNm").getLength() > 0) {
						str = e.getElementsByTagName("peopleNm").item(0).getTextContent();
						if (str != null) vo.setPeopleNm(str);
					}
					
					list.add(vo);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (con != null) con.disconnect();
		}
		
		return err;
	}
}


/*
<faultResult>
<faultInfo class="object">
<errorCode type="string">320010</errorCode>
<message type="string">유효하지않은 키값입니다.</message>
</faultInfo>
</faultResult>

<movieListResult>
<totCnt>111116</totCnt>
<movieList>
<movie>
<movieCd>20253224</movieCd>
<movieNm>다시 만날, 조국</movieNm>
<movieNmEn/>
<prdtYear>2025</prdtYear>
<openDt/>
<typeNm>장편</typeNm>
<prdtStatNm>개봉예정</prdtStatNm>
<nationAlt>한국</nationAlt>
<genreAlt>다큐멘터리</genreAlt>
<repNationNm>한국</repNationNm>
<repGenreNm>다큐멘터리</repGenreNm>
<directors>
<director>
<peopleNm>정윤철</peopleNm>
</director>
<director>
<peopleNm>정상진</peopleNm>
</director>
</directors>
<companys/>
</movie>
<movie>
</movie>
</movieList>
<source>영화진흥위원회</source>
</movieListResult>
 */
		
package com.roc.springboot.spring_boot_demo.ex4;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.halLinks;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.relaxedLinks;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap; 
/**
 * 用于生产rest api文档
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebLayerDocumentation extends SpringRestDocApplicationTest{

	@Test
	public void indexAccount() throws Exception {
		this.mockMvc.perform(get("/account/"))
		.andExpect(status().isOk())
		.andDo(document("restful-account-index",links(
				linkWithRel("msg").description("Link to the alpha resource"),
				linkWithRel("success").description("<<resources-restful-account-index,Links>> to the bravo resource")),
				  relaxedResponseFields(
                          fieldWithPath("money").type("money").description("资金"),
                          fieldWithPath("name").type("name").description("名称"),
                          fieldWithPath("_links").type("data").description("连接"))));
	}
	@Test
	public void addAccount() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "yupaopao");
        params.add("money", "98855");
		mockMvc.perform(post("/account/").params(params))
		.andExpect(status().isOk())
		.andDo(document("restful-account-add", 
				requestParameters(
		                  parameterWithName("name").description("名称"),
		                  parameterWithName("money").description("资金")),
				  relaxedResponseFields(
                          fieldWithPath("msg").type("msg").description("消息"),
                          fieldWithPath("success").type("success").description("成功标识"))));
	}
	
	@Test
	public void updateAccount() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("name", "yupaopao");
        params.add("money", "98855");
		mockMvc.perform(put("/account/{id}",6).params(params))
		.andExpect(status().isOk())
		.andDo(document("restful-account-update", 
				  requestParameters(
		                  parameterWithName("name").description("名称"),
		                  parameterWithName("money").description("资金")),
				  relaxedResponseFields(
                          fieldWithPath("msg").type("msg").description("消息"),
                          fieldWithPath("success").type("success").description("成功标识"))));
	}
	
	@Test
	public void getAccount() throws Exception {
		mockMvc.perform(get("/account/{id}",6).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(document("restful-account-get",
				  relaxedResponseFields(
                          fieldWithPath("id").type("Integer").description("得到的ID"),
                          fieldWithPath("name").type("data.name").description("得到的名称"),
                          fieldWithPath("money").type("data.name").description("得到的资金"))));
	}
	
}

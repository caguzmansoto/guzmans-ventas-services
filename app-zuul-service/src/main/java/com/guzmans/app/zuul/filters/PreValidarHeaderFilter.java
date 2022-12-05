package com.guzmans.app.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PreValidarHeaderFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(PreValidarHeaderFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String usuario=request.getHeader("usuario")==null?"":request.getHeader("usuario");
		String password=request.getHeader("clave")==null?"":request.getHeader("clave");

		if (!usuario.equals("guzmans") || !password.equals("guzmans")){
			String msgError="Usuario y/o clave invalidos en el header";
			ctx.setResponseBody(msgError);
			ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
			ctx.setSendZuulResponse(false);
			log.info(msgError);
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}

/**
 *
 *     Copyright (C) 2012 Jacek Obarymski
 *
 *     This file is part of SOAP/REST Mock Service.
 *
 *     SOAP/REST Mock Service is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License, version 3
 *     as published by the Free Software Foundation.
 *
 *     SOAP/REST Mock Service is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with SOAP/REST Mock Service; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package net.sf.jaceko.mock.matcher;

import net.sf.jaceko.mock.model.webservice.WebserviceOperation;
import org.hamcrest.Description;
import org.mockito.ArgumentMatcher;

import javax.ws.rs.core.MediaType;

public class OperationHavingDefaultResponseContentTypeEqualTo extends ArgumentMatcher<WebserviceOperation> {
    private WebserviceOperation operation;
    private final String defaultResponseContentType;

    @Override
    public boolean matches(Object argument) {
        operation = (WebserviceOperation) argument;
        return defaultResponseContentType.equals(operation.getDefaultResponseContentType());
    }

    public OperationHavingDefaultResponseContentTypeEqualTo(MediaType defaultResponseContentType) {
        super();
        this.defaultResponseContentType = defaultResponseContentType.toString();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("operation having defaultResponseContentType = " + defaultResponseContentType
            + " but is operation having defaultResponseContentType = " + operation.getDefaultResponseContentType());
    }

}

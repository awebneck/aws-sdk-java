/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.cloudfront.model;

import java.io.Serializable;

/**
 * <p>
 * A complex type that specifies how CloudFront handles query strings,
 * cookies and headers.
 * </p>
 */
public class ForwardedValues implements Serializable, Cloneable {

    /**
     * Indicates whether you want CloudFront to forward query strings to the
     * origin that is associated with this cache behavior. If so, specify
     * true; if not, specify false.
     */
    private Boolean queryString;

    /**
     * A complex type that specifies how CloudFront handles cookies.
     */
    private CookiePreference cookies;

    /**
     * A complex type that specifies the Headers, if any, that you want
     * CloudFront to vary upon for this cache behavior.
     */
    private Headers headers;

    /**
     * Indicates whether you want CloudFront to forward query strings to the
     * origin that is associated with this cache behavior. If so, specify
     * true; if not, specify false.
     *
     * @return Indicates whether you want CloudFront to forward query strings to the
     *         origin that is associated with this cache behavior. If so, specify
     *         true; if not, specify false.
     */
    public Boolean isQueryString() {
        return queryString;
    }
    
    /**
     * Indicates whether you want CloudFront to forward query strings to the
     * origin that is associated with this cache behavior. If so, specify
     * true; if not, specify false.
     *
     * @param queryString Indicates whether you want CloudFront to forward query strings to the
     *         origin that is associated with this cache behavior. If so, specify
     *         true; if not, specify false.
     */
    public void setQueryString(Boolean queryString) {
        this.queryString = queryString;
    }
    
    /**
     * Indicates whether you want CloudFront to forward query strings to the
     * origin that is associated with this cache behavior. If so, specify
     * true; if not, specify false.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param queryString Indicates whether you want CloudFront to forward query strings to the
     *         origin that is associated with this cache behavior. If so, specify
     *         true; if not, specify false.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ForwardedValues withQueryString(Boolean queryString) {
        this.queryString = queryString;
        return this;
    }

    /**
     * Indicates whether you want CloudFront to forward query strings to the
     * origin that is associated with this cache behavior. If so, specify
     * true; if not, specify false.
     *
     * @return Indicates whether you want CloudFront to forward query strings to the
     *         origin that is associated with this cache behavior. If so, specify
     *         true; if not, specify false.
     */
    public Boolean getQueryString() {
        return queryString;
    }

    /**
     * A complex type that specifies how CloudFront handles cookies.
     *
     * @return A complex type that specifies how CloudFront handles cookies.
     */
    public CookiePreference getCookies() {
        return cookies;
    }
    
    /**
     * A complex type that specifies how CloudFront handles cookies.
     *
     * @param cookies A complex type that specifies how CloudFront handles cookies.
     */
    public void setCookies(CookiePreference cookies) {
        this.cookies = cookies;
    }
    
    /**
     * A complex type that specifies how CloudFront handles cookies.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cookies A complex type that specifies how CloudFront handles cookies.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ForwardedValues withCookies(CookiePreference cookies) {
        this.cookies = cookies;
        return this;
    }

    /**
     * A complex type that specifies the Headers, if any, that you want
     * CloudFront to vary upon for this cache behavior.
     *
     * @return A complex type that specifies the Headers, if any, that you want
     *         CloudFront to vary upon for this cache behavior.
     */
    public Headers getHeaders() {
        return headers;
    }
    
    /**
     * A complex type that specifies the Headers, if any, that you want
     * CloudFront to vary upon for this cache behavior.
     *
     * @param headers A complex type that specifies the Headers, if any, that you want
     *         CloudFront to vary upon for this cache behavior.
     */
    public void setHeaders(Headers headers) {
        this.headers = headers;
    }
    
    /**
     * A complex type that specifies the Headers, if any, that you want
     * CloudFront to vary upon for this cache behavior.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param headers A complex type that specifies the Headers, if any, that you want
     *         CloudFront to vary upon for this cache behavior.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ForwardedValues withHeaders(Headers headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (isQueryString() != null) sb.append("QueryString: " + isQueryString() + ",");
        if (getCookies() != null) sb.append("Cookies: " + getCookies() + ",");
        if (getHeaders() != null) sb.append("Headers: " + getHeaders() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((isQueryString() == null) ? 0 : isQueryString().hashCode()); 
        hashCode = prime * hashCode + ((getCookies() == null) ? 0 : getCookies().hashCode()); 
        hashCode = prime * hashCode + ((getHeaders() == null) ? 0 : getHeaders().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof ForwardedValues == false) return false;
        ForwardedValues other = (ForwardedValues)obj;
        
        if (other.isQueryString() == null ^ this.isQueryString() == null) return false;
        if (other.isQueryString() != null && other.isQueryString().equals(this.isQueryString()) == false) return false; 
        if (other.getCookies() == null ^ this.getCookies() == null) return false;
        if (other.getCookies() != null && other.getCookies().equals(this.getCookies()) == false) return false; 
        if (other.getHeaders() == null ^ this.getHeaders() == null) return false;
        if (other.getHeaders() != null && other.getHeaders().equals(this.getHeaders()) == false) return false; 
        return true;
    }
    
    @Override
    public ForwardedValues clone() {
        try {
            return (ForwardedValues) super.clone();
        
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                    + "even though we're Cloneable!",
                    e);
        }
        
    }

}
    
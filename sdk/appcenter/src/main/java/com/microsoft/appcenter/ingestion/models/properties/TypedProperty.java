/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 */

package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.Model;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import static com.microsoft.appcenter.ingestion.models.CommonProperties.NAME;
import static com.microsoft.appcenter.ingestion.models.CommonProperties.TYPE;

public abstract class TypedProperty implements Model {

    /**
     * Property name.
     */
    private String name;

    /**
     * Get the type value.
     *
     * @return the type value.
     */
    public abstract String getType();

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void read(JSONObject object) throws JSONException {
        if (!object.getString(TYPE).equals(getType())) {
            throw new JSONException("Invalid type");
        }
        setName(object.getString(NAME));
    }

    @Override
    public void write(JSONStringer writer) throws JSONException {
        writer.key(TYPE).value(getType());
        writer.key(NAME).value(getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypedProperty that = (TypedProperty) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

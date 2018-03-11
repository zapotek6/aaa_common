package uk.co.labfour.cloud2.aaa.common;

import uk.co.labfour.bjson.BJsonArray;
import uk.co.labfour.bjson.BJsonException;
import uk.co.labfour.bjson.BJsonObject;
import uk.co.labfour.error.BException;

import java.util.Vector;

import static uk.co.labfour.cloud2.aaa.common.AAAConstants.OPERATIONS_ARRAY_CONTAINER_FLD;

public class AAAEntityOperationsBuilder {
    Vector<AAAEntityOperationBuilder> operations= new Vector<>();

    public AAAEntityOperationsBuilder add(AAAEntityOperationBuilder operation) {
        operations.add(operation);

        return this;
    }

    public String getObjectName() {
        return OPERATIONS_ARRAY_CONTAINER_FLD;
    }

    public BJsonArray build() throws BException {
        BJsonArray jOperations = new BJsonArray();

        for (AAAEntityOperationBuilder ope: operations) {
            jOperations.add(ope.build());
        }

        return jOperations;
    }
}

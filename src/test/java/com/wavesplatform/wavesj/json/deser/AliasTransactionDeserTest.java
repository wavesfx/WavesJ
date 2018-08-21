package com.wavesplatform.wavesj.json.deser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavesplatform.wavesj.Alias;
import com.wavesplatform.wavesj.Asset;
import com.wavesplatform.wavesj.ByteString;
import com.wavesplatform.wavesj.PublicKeyAccount;
import com.wavesplatform.wavesj.json.WavesJsonMapper;
import com.wavesplatform.wavesj.transactions.AliasTransactionV1;
import com.wavesplatform.wavesj.transactions.AliasTransactionV2;
import com.wavesplatform.wavesj.transactions.TransferTransactionV1;
import com.wavesplatform.wavesj.transactions.TransferTransactionV2;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class AliasTransactionDeserTest {
    ObjectMapper mapper = new WavesJsonMapper((byte) 'T');
    AliasTransactionV1 txV1 = new AliasTransactionV1(new PublicKeyAccount("FM5ojNqW7e9cZ9zhPYGkpSP1Pcd8Z3e3MNKYVS5pGJ8Z", (byte) 'T'), new Alias("myalias", (byte) 'T'), 100000, 1526910778245L, new ByteString("CC1jQ4qkuVfMvB2Kpg2Go6QKXJxUFC8UUswUxBsxwisrR8N5s3Yc8zA6dhjTwfWKfdouSTAnRXCxTXb3T6pJq3T"));
    AliasTransactionV2 txV2 = new AliasTransactionV2(new PublicKeyAccount("FM5ojNqW7e9cZ9zhPYGkpSP1Pcd8Z3e3MNKYVS5pGJ8Z", (byte) 'T'), new Alias("myalias", (byte) 'T'), 100000, 1526910778245L, Collections.singletonList(new ByteString("26U7rQTwpdma5GYSZb5bNygVCtSuWL6DKet1Nauf5J57v19mmfnq434YrkKYJqvYt2ydQBUT3P7Xgj5ZVDVAcc5k")));

    @Test
    public void V1DeserializeTest() throws IOException {
        AliasTransactionV1 deserialized = mapper.readValue("{\"type\":10,\"id\":\"7acjQQWJAharrgzb4Z6jo3eeAKAGPmLkHTPtvBTKaiug\",\"sender\":\"3N5GRqzDBhjVXnCn44baHcz2GoZy5qLxtTh\",\"senderPublicKey\":\"FM5ojNqW7e9cZ9zhPYGkpSP1Pcd8Z3e3MNKYVS5pGJ8Z\",\"fee\":100000,\"timestamp\":1526910778245,\"signature\":\"CC1jQ4qkuVfMvB2Kpg2Go6QKXJxUFC8UUswUxBsxwisrR8N5s3Yc8zA6dhjTwfWKfdouSTAnRXCxTXb3T6pJq3T\",\"version\":1,\"alias\":\"myalias\"}", AliasTransactionV1.class);
        assertEquals(deserialized, txV1);
        assertEquals(deserialized.getId(), txV1.getId());
    }

    @Test
    public void V2DeserializeTest() throws IOException {
        AliasTransactionV2 deserialized = mapper.readValue("{\"type\":10,\"id\":\"7acjQQWJAharrgzb4Z6jo3eeAKAGPmLkHTPtvBTKaiug\",\"sender\":\"3N5GRqzDBhjVXnCn44baHcz2GoZy5qLxtTh\",\"senderPublicKey\":\"FM5ojNqW7e9cZ9zhPYGkpSP1Pcd8Z3e3MNKYVS5pGJ8Z\",\"fee\":100000,\"timestamp\":1526910778245,\"proofs\":[\"26U7rQTwpdma5GYSZb5bNygVCtSuWL6DKet1Nauf5J57v19mmfnq434YrkKYJqvYt2ydQBUT3P7Xgj5ZVDVAcc5k\"],\"version\":2,\"alias\":\"myalias\"}", AliasTransactionV2.class);
        assertEquals(deserialized, txV2);
        assertEquals(deserialized.getId(), txV2.getId());
    }
}

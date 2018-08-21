package com.wavesplatform.wavesj.json.deser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavesplatform.wavesj.Base58;
import com.wavesplatform.wavesj.ByteString;
import com.wavesplatform.wavesj.PublicKeyAccount;
import com.wavesplatform.wavesj.json.WavesJsonMapper;
import com.wavesplatform.wavesj.transactions.LeaseTransactionV1;
import com.wavesplatform.wavesj.transactions.LeaseTransactionV2;
import com.wavesplatform.wavesj.transactions.ReissueTransactionV1;
import com.wavesplatform.wavesj.transactions.ReissueTransactionV2;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReissueTransactionDeserTest {
    ObjectMapper mapper = new WavesJsonMapper((byte) 'T');

    ReissueTransactionV1 txV1 = new ReissueTransactionV1(new PublicKeyAccount("FM5ojNqW7e9cZ9zhPYGkpSP1Pcd8Z3e3MNKYVS5pGJ8Z", (byte) 'T'), "9ekQuYn92natMnMq8KqeGK3Nn7cpKd3BvPEGgD6fFyyz", 100000000L, true, 100000000L, 1526287561757L, new ByteString("3LnRMrjkk7RoV35PTwcdB4yW2rqUqXaKAh8DnPk5tNWABvhVQ9oqdTk3zM8b9AbGtry7WEcQZtevfK92DCFaa6hA"));
    ReissueTransactionV2 txV2 = new ReissueTransactionV2(new PublicKeyAccount("FM5ojNqW7e9cZ9zhPYGkpSP1Pcd8Z3e3MNKYVS5pGJ8Z", (byte) 'T'), (byte)'T', "9ekQuYn92natMnMq8KqeGK3Nn7cpKd3BvPEGgD6fFyyz", 100000000L, true, 100000000L, 1526287561757L, Collections.singletonList(new ByteString("4DFEtUwJ9gjMQMuEXipv2qK7rnhhWEBqzpC3ZQesW1Kh8D822t62e3cRGWNU3N21r7huWnaty95wj2tZxYSvCfro")));

    @Test
    public void V1DeserializeTest() throws IOException {
        ReissueTransactionV1 deserialized = mapper.readValue("{\"type\":5,\"id\":\"2y8pNQteNQnY5JWtrZGLUv3tD6GFT6DDzBWttVTwBa2t\",\"sender\":\"3N5GRqzDBhjVXnCn44baHcz2GoZy5qLxtTh\",\"senderPublicKey\":\"FM5ojNqW7e9cZ9zhPYGkpSP1Pcd8Z3e3MNKYVS5pGJ8Z\",\"fee\":100000000,\"timestamp\":1526287561757,\"signature\":\"3LnRMrjkk7RoV35PTwcdB4yW2rqUqXaKAh8DnPk5tNWABvhVQ9oqdTk3zM8b9AbGtry7WEcQZtevfK92DCFaa6hA\",\"version\":1,\"chainId\":null,\"assetId\":\"9ekQuYn92natMnMq8KqeGK3Nn7cpKd3BvPEGgD6fFyyz\",\"quantity\":100000000,\"reissuable\":true}", ReissueTransactionV1.class);
        assertEquals(deserialized, txV1);
        assertEquals(deserialized.getId(), txV1.getId());
    }

    @Test
    public void V2DeserializeTest() throws IOException {
        ReissueTransactionV2 deserialized = mapper.readValue("{\"type\":5,\"id\":\"HbQ7gMoDyRxSU6LbLLBVNTbxASaR8rm4Zck6eYvWVUkB\",\"sender\":\"3N5GRqzDBhjVXnCn44baHcz2GoZy5qLxtTh\",\"senderPublicKey\":\"FM5ojNqW7e9cZ9zhPYGkpSP1Pcd8Z3e3MNKYVS5pGJ8Z\",\"fee\":100000000,\"timestamp\":1526287561757,\"proofs\":[\"4DFEtUwJ9gjMQMuEXipv2qK7rnhhWEBqzpC3ZQesW1Kh8D822t62e3cRGWNU3N21r7huWnaty95wj2tZxYSvCfro\"],\"version\":2,\"chainId\":84,\"assetId\":\"9ekQuYn92natMnMq8KqeGK3Nn7cpKd3BvPEGgD6fFyyz\",\"quantity\":100000000,\"reissuable\":true}", ReissueTransactionV2.class);
        assertEquals(deserialized, txV2);
        assertEquals(deserialized.getId(), txV2.getId());
    }
}

package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.initNewBlock("12343");
        blockchain.initNewBlock("176543");
        blockchain.initNewBlock("fghsgdfg");
        blockchain.initNewBlock("sdfhgdf");
        blockchain.initNewBlock("sdaghsrghdg");
        for (Block block : blockchain.blockchain) {
            System.out.println(block.toString());
        }
    }
}

class Block {
    private static int ID = 0;
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    private long timeToCreate;
    private int nonce;
    private int myId;


    public Block(String data, String previousHash, long timeStamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.hash = calculateBlockHash();
        ID++;
        this.myId = ID;
    }

    public int getNonce() {
        return nonce;
    }

    public int getMyId() {
        return myId;
    }

    public long getTimeToCreate() {
        return timeToCreate;
    }

    public String mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        timeToCreate = new Date().getTime();
        while (!hash.substring(0, prefix)
                .equals(prefixString)) {
            nonce++;
            hash = calculateBlockHash();
        }
        timeToCreate = new Date().getTime() - timeToCreate;
        return hash;
    }

    public String calculateBlockHash() {
        String dataToHash = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data;
        MessageDigest digest = null;
        byte[] bytes = null;
        try {

            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public String getHash() {
        return this.hash;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Block: \n")
                .append("Created by miner #"+ "\n")
                .append("Id: " + getMyId())
                .append("\nTimestamp: " + timeStamp)
                .append("\nMagic number: " + getNonce())
                .append("\nHash of the previous block:\n" + previousHash)
                .append("\nHash of the block:\n" + getHash())
                .append("\nBlock was generating for " + timeToCreate)
                .append(" seconds\n")
                .append("N was increased to"+ "\n");

        return stringBuilder.toString();
    }
}

class Blockchain {

    public static String previousHash = "0";
    public List<Block> blockchain = new ArrayList<>();
    public static int prefix = 0;
    public String prefixString = new String(new char[prefix]).replace('\0', '0');

    public void initNewBlock(String data) {
        Block block = new Block(data, previousHash, new Date().getTime());
        block.mineBlock(prefix);
        previousHash = block.getHash();
        blockchain.add(block);
    }


//    public void givenBlockchain_whenNewBlockAdded_thenSuccess() {
//        Block newBlock = new Block("The is a New Block.", blockchain.get(blockchain.size() - 1)
//                .getHash(), new Date().getTime());
//        newBlock.mineBlock(prefix);
//        assertTrue(newBlock.getHash()
//                .substring(0, prefix)
//                .equals(prefixString));
//        blockchain.add(newBlock);
//    }


    public boolean givenBlockchain_whenValidated_thenSuccess() {
        boolean flag = true;
        for (int i = 0; i < blockchain.size(); i++) {
            String previousHash = i == 0 ? "0"
                    : blockchain.get(i - 1)
                    .getHash();
            flag = blockchain.get(i)
                    .getHash()
                    .equals(blockchain.get(i)
                            .calculateBlockHash())
                    && previousHash.equals(blockchain.get(i)
                    .getPreviousHash())
                    && blockchain.get(i)
                    .getHash()
                    .substring(0, prefix)
                    .equals(prefixString);
            if (!flag)
                break;
        }
        return flag;
    }
}
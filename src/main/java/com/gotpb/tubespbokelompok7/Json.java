package com.gotpb.tubespbokelompok7;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Json {
        public static ArrayList<String> jsonReader() {
                try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode json = objectMapper.readTree(new File("C:/Tubes PBO Kelompok 7/src/main/java/com/gotpb/tubespbokelompok7/msg.json"));
                        ArrayList<String> pesan = new ArrayList<>();
                        String msg = null;
                        for (JsonNode test : json) {
                                msg = json.get("msg").asText();
                                pesan.add(msg);

                        }
                        return pesan;
                } catch (IOException ie) {
                        ie.printStackTrace();
                }
                return null;
        }
        }


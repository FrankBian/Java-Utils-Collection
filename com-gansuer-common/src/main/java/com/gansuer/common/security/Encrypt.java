package com.gansuer.common.security;

public interface Encrypt {

    byte[] encryptBytes(byte[] buffer);

    byte[] encryptBefaultBytes(byte[] buffer);
    
}
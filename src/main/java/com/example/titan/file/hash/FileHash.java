package com.example.titan.file.hash;

import com.example.titan.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}

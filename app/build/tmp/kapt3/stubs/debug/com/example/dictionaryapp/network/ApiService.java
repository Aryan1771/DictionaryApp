package com.example.dictionaryapp.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ$\u0010\u000b\u001a\u00020\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/dictionaryapp/network/ApiService;", "", "getMeaning", "Lretrofit2/Response;", "", "Lcom/example/dictionaryapp/data/model/DictionaryResponse;", "word", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSlang", "Lcom/example/dictionaryapp/data/model/UrbanResponse;", "translate", "Lcom/example/dictionaryapp/data/model/TranslationResponse;", "body", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "api/v2/entries/en/{word}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMeaning(@retrofit2.http.Path(value = "word")
    @org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.dictionaryapp.data.model.DictionaryResponse>>> $completion);
    
    @retrofit2.http.GET(value = "v0/define")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSlang(@retrofit2.http.Query(value = "term")
    @org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dictionaryapp.data.model.UrbanResponse> $completion);
    
    @retrofit2.http.POST(value = "translate")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object translate(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> body, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.dictionaryapp.data.model.TranslationResponse> $completion);
}
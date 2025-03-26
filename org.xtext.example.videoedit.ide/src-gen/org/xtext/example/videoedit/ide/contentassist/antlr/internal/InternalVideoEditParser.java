package org.xtext.example.videoedit.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.videoedit.services.VideoEditGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalVideoEditParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'V1'", "'V2'", "'V3'", "'A1'", "'A2'", "'A3'", "'project'", "'{'", "'}'", "'track'", "'clip'", "'source:'", "'source_in:'", "'source_out:'", "'target_position:'", "'sync_with:'", "'audio_level:'", "'%'", "':'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalVideoEditParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalVideoEditParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalVideoEditParser.tokenNames; }
    public String getGrammarFileName() { return "InternalVideoEdit.g"; }


    	private VideoEditGrammarAccess grammarAccess;

    	public void setGrammarAccess(VideoEditGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleProject"
    // InternalVideoEdit.g:53:1: entryRuleProject : ruleProject EOF ;
    public final void entryRuleProject() throws RecognitionException {
        try {
            // InternalVideoEdit.g:54:1: ( ruleProject EOF )
            // InternalVideoEdit.g:55:1: ruleProject EOF
            {
             before(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            ruleProject();

            state._fsp--;

             after(grammarAccess.getProjectRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalVideoEdit.g:62:1: ruleProject : ( ( rule__Project__Group__0 ) ) ;
    public final void ruleProject() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:66:2: ( ( ( rule__Project__Group__0 ) ) )
            // InternalVideoEdit.g:67:2: ( ( rule__Project__Group__0 ) )
            {
            // InternalVideoEdit.g:67:2: ( ( rule__Project__Group__0 ) )
            // InternalVideoEdit.g:68:3: ( rule__Project__Group__0 )
            {
             before(grammarAccess.getProjectAccess().getGroup()); 
            // InternalVideoEdit.g:69:3: ( rule__Project__Group__0 )
            // InternalVideoEdit.g:69:4: rule__Project__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleTrack"
    // InternalVideoEdit.g:78:1: entryRuleTrack : ruleTrack EOF ;
    public final void entryRuleTrack() throws RecognitionException {
        try {
            // InternalVideoEdit.g:79:1: ( ruleTrack EOF )
            // InternalVideoEdit.g:80:1: ruleTrack EOF
            {
             before(grammarAccess.getTrackRule()); 
            pushFollow(FOLLOW_1);
            ruleTrack();

            state._fsp--;

             after(grammarAccess.getTrackRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrack"


    // $ANTLR start "ruleTrack"
    // InternalVideoEdit.g:87:1: ruleTrack : ( ( rule__Track__Group__0 ) ) ;
    public final void ruleTrack() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:91:2: ( ( ( rule__Track__Group__0 ) ) )
            // InternalVideoEdit.g:92:2: ( ( rule__Track__Group__0 ) )
            {
            // InternalVideoEdit.g:92:2: ( ( rule__Track__Group__0 ) )
            // InternalVideoEdit.g:93:3: ( rule__Track__Group__0 )
            {
             before(grammarAccess.getTrackAccess().getGroup()); 
            // InternalVideoEdit.g:94:3: ( rule__Track__Group__0 )
            // InternalVideoEdit.g:94:4: rule__Track__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Track__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrackAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrack"


    // $ANTLR start "entryRuleClip"
    // InternalVideoEdit.g:103:1: entryRuleClip : ruleClip EOF ;
    public final void entryRuleClip() throws RecognitionException {
        try {
            // InternalVideoEdit.g:104:1: ( ruleClip EOF )
            // InternalVideoEdit.g:105:1: ruleClip EOF
            {
             before(grammarAccess.getClipRule()); 
            pushFollow(FOLLOW_1);
            ruleClip();

            state._fsp--;

             after(grammarAccess.getClipRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleClip"


    // $ANTLR start "ruleClip"
    // InternalVideoEdit.g:112:1: ruleClip : ( ( rule__Clip__Group__0 ) ) ;
    public final void ruleClip() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:116:2: ( ( ( rule__Clip__Group__0 ) ) )
            // InternalVideoEdit.g:117:2: ( ( rule__Clip__Group__0 ) )
            {
            // InternalVideoEdit.g:117:2: ( ( rule__Clip__Group__0 ) )
            // InternalVideoEdit.g:118:3: ( rule__Clip__Group__0 )
            {
             before(grammarAccess.getClipAccess().getGroup()); 
            // InternalVideoEdit.g:119:3: ( rule__Clip__Group__0 )
            // InternalVideoEdit.g:119:4: rule__Clip__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Clip__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClipAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleClip"


    // $ANTLR start "entryRuleAudioLevel"
    // InternalVideoEdit.g:128:1: entryRuleAudioLevel : ruleAudioLevel EOF ;
    public final void entryRuleAudioLevel() throws RecognitionException {
        try {
            // InternalVideoEdit.g:129:1: ( ruleAudioLevel EOF )
            // InternalVideoEdit.g:130:1: ruleAudioLevel EOF
            {
             before(grammarAccess.getAudioLevelRule()); 
            pushFollow(FOLLOW_1);
            ruleAudioLevel();

            state._fsp--;

             after(grammarAccess.getAudioLevelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAudioLevel"


    // $ANTLR start "ruleAudioLevel"
    // InternalVideoEdit.g:137:1: ruleAudioLevel : ( ( rule__AudioLevel__Group__0 ) ) ;
    public final void ruleAudioLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:141:2: ( ( ( rule__AudioLevel__Group__0 ) ) )
            // InternalVideoEdit.g:142:2: ( ( rule__AudioLevel__Group__0 ) )
            {
            // InternalVideoEdit.g:142:2: ( ( rule__AudioLevel__Group__0 ) )
            // InternalVideoEdit.g:143:3: ( rule__AudioLevel__Group__0 )
            {
             before(grammarAccess.getAudioLevelAccess().getGroup()); 
            // InternalVideoEdit.g:144:3: ( rule__AudioLevel__Group__0 )
            // InternalVideoEdit.g:144:4: rule__AudioLevel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AudioLevel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAudioLevelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAudioLevel"


    // $ANTLR start "entryRuleTimeCode"
    // InternalVideoEdit.g:153:1: entryRuleTimeCode : ruleTimeCode EOF ;
    public final void entryRuleTimeCode() throws RecognitionException {
        try {
            // InternalVideoEdit.g:154:1: ( ruleTimeCode EOF )
            // InternalVideoEdit.g:155:1: ruleTimeCode EOF
            {
             before(grammarAccess.getTimeCodeRule()); 
            pushFollow(FOLLOW_1);
            ruleTimeCode();

            state._fsp--;

             after(grammarAccess.getTimeCodeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTimeCode"


    // $ANTLR start "ruleTimeCode"
    // InternalVideoEdit.g:162:1: ruleTimeCode : ( ( rule__TimeCode__Group__0 ) ) ;
    public final void ruleTimeCode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:166:2: ( ( ( rule__TimeCode__Group__0 ) ) )
            // InternalVideoEdit.g:167:2: ( ( rule__TimeCode__Group__0 ) )
            {
            // InternalVideoEdit.g:167:2: ( ( rule__TimeCode__Group__0 ) )
            // InternalVideoEdit.g:168:3: ( rule__TimeCode__Group__0 )
            {
             before(grammarAccess.getTimeCodeAccess().getGroup()); 
            // InternalVideoEdit.g:169:3: ( rule__TimeCode__Group__0 )
            // InternalVideoEdit.g:169:4: rule__TimeCode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TimeCode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeCodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTimeCode"


    // $ANTLR start "ruleTrackType"
    // InternalVideoEdit.g:178:1: ruleTrackType : ( ( rule__TrackType__Alternatives ) ) ;
    public final void ruleTrackType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:182:1: ( ( ( rule__TrackType__Alternatives ) ) )
            // InternalVideoEdit.g:183:2: ( ( rule__TrackType__Alternatives ) )
            {
            // InternalVideoEdit.g:183:2: ( ( rule__TrackType__Alternatives ) )
            // InternalVideoEdit.g:184:3: ( rule__TrackType__Alternatives )
            {
             before(grammarAccess.getTrackTypeAccess().getAlternatives()); 
            // InternalVideoEdit.g:185:3: ( rule__TrackType__Alternatives )
            // InternalVideoEdit.g:185:4: rule__TrackType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TrackType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTrackTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrackType"


    // $ANTLR start "rule__TrackType__Alternatives"
    // InternalVideoEdit.g:193:1: rule__TrackType__Alternatives : ( ( ( 'V1' ) ) | ( ( 'V2' ) ) | ( ( 'V3' ) ) | ( ( 'A1' ) ) | ( ( 'A2' ) ) | ( ( 'A3' ) ) );
    public final void rule__TrackType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:197:1: ( ( ( 'V1' ) ) | ( ( 'V2' ) ) | ( ( 'V3' ) ) | ( ( 'A1' ) ) | ( ( 'A2' ) ) | ( ( 'A3' ) ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            case 15:
                {
                alt1=5;
                }
                break;
            case 16:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalVideoEdit.g:198:2: ( ( 'V1' ) )
                    {
                    // InternalVideoEdit.g:198:2: ( ( 'V1' ) )
                    // InternalVideoEdit.g:199:3: ( 'V1' )
                    {
                     before(grammarAccess.getTrackTypeAccess().getV1EnumLiteralDeclaration_0()); 
                    // InternalVideoEdit.g:200:3: ( 'V1' )
                    // InternalVideoEdit.g:200:4: 'V1'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getTrackTypeAccess().getV1EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalVideoEdit.g:204:2: ( ( 'V2' ) )
                    {
                    // InternalVideoEdit.g:204:2: ( ( 'V2' ) )
                    // InternalVideoEdit.g:205:3: ( 'V2' )
                    {
                     before(grammarAccess.getTrackTypeAccess().getV2EnumLiteralDeclaration_1()); 
                    // InternalVideoEdit.g:206:3: ( 'V2' )
                    // InternalVideoEdit.g:206:4: 'V2'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getTrackTypeAccess().getV2EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalVideoEdit.g:210:2: ( ( 'V3' ) )
                    {
                    // InternalVideoEdit.g:210:2: ( ( 'V3' ) )
                    // InternalVideoEdit.g:211:3: ( 'V3' )
                    {
                     before(grammarAccess.getTrackTypeAccess().getV3EnumLiteralDeclaration_2()); 
                    // InternalVideoEdit.g:212:3: ( 'V3' )
                    // InternalVideoEdit.g:212:4: 'V3'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getTrackTypeAccess().getV3EnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalVideoEdit.g:216:2: ( ( 'A1' ) )
                    {
                    // InternalVideoEdit.g:216:2: ( ( 'A1' ) )
                    // InternalVideoEdit.g:217:3: ( 'A1' )
                    {
                     before(grammarAccess.getTrackTypeAccess().getA1EnumLiteralDeclaration_3()); 
                    // InternalVideoEdit.g:218:3: ( 'A1' )
                    // InternalVideoEdit.g:218:4: 'A1'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getTrackTypeAccess().getA1EnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalVideoEdit.g:222:2: ( ( 'A2' ) )
                    {
                    // InternalVideoEdit.g:222:2: ( ( 'A2' ) )
                    // InternalVideoEdit.g:223:3: ( 'A2' )
                    {
                     before(grammarAccess.getTrackTypeAccess().getA2EnumLiteralDeclaration_4()); 
                    // InternalVideoEdit.g:224:3: ( 'A2' )
                    // InternalVideoEdit.g:224:4: 'A2'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getTrackTypeAccess().getA2EnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalVideoEdit.g:228:2: ( ( 'A3' ) )
                    {
                    // InternalVideoEdit.g:228:2: ( ( 'A3' ) )
                    // InternalVideoEdit.g:229:3: ( 'A3' )
                    {
                     before(grammarAccess.getTrackTypeAccess().getA3EnumLiteralDeclaration_5()); 
                    // InternalVideoEdit.g:230:3: ( 'A3' )
                    // InternalVideoEdit.g:230:4: 'A3'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getTrackTypeAccess().getA3EnumLiteralDeclaration_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrackType__Alternatives"


    // $ANTLR start "rule__Project__Group__0"
    // InternalVideoEdit.g:238:1: rule__Project__Group__0 : rule__Project__Group__0__Impl rule__Project__Group__1 ;
    public final void rule__Project__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:242:1: ( rule__Project__Group__0__Impl rule__Project__Group__1 )
            // InternalVideoEdit.g:243:2: rule__Project__Group__0__Impl rule__Project__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Project__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__0"


    // $ANTLR start "rule__Project__Group__0__Impl"
    // InternalVideoEdit.g:250:1: rule__Project__Group__0__Impl : ( 'project' ) ;
    public final void rule__Project__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:254:1: ( ( 'project' ) )
            // InternalVideoEdit.g:255:1: ( 'project' )
            {
            // InternalVideoEdit.g:255:1: ( 'project' )
            // InternalVideoEdit.g:256:2: 'project'
            {
             before(grammarAccess.getProjectAccess().getProjectKeyword_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getProjectKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__0__Impl"


    // $ANTLR start "rule__Project__Group__1"
    // InternalVideoEdit.g:265:1: rule__Project__Group__1 : rule__Project__Group__1__Impl rule__Project__Group__2 ;
    public final void rule__Project__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:269:1: ( rule__Project__Group__1__Impl rule__Project__Group__2 )
            // InternalVideoEdit.g:270:2: rule__Project__Group__1__Impl rule__Project__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Project__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__1"


    // $ANTLR start "rule__Project__Group__1__Impl"
    // InternalVideoEdit.g:277:1: rule__Project__Group__1__Impl : ( ( rule__Project__NameAssignment_1 ) ) ;
    public final void rule__Project__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:281:1: ( ( ( rule__Project__NameAssignment_1 ) ) )
            // InternalVideoEdit.g:282:1: ( ( rule__Project__NameAssignment_1 ) )
            {
            // InternalVideoEdit.g:282:1: ( ( rule__Project__NameAssignment_1 ) )
            // InternalVideoEdit.g:283:2: ( rule__Project__NameAssignment_1 )
            {
             before(grammarAccess.getProjectAccess().getNameAssignment_1()); 
            // InternalVideoEdit.g:284:2: ( rule__Project__NameAssignment_1 )
            // InternalVideoEdit.g:284:3: rule__Project__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Project__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getProjectAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__1__Impl"


    // $ANTLR start "rule__Project__Group__2"
    // InternalVideoEdit.g:292:1: rule__Project__Group__2 : rule__Project__Group__2__Impl rule__Project__Group__3 ;
    public final void rule__Project__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:296:1: ( rule__Project__Group__2__Impl rule__Project__Group__3 )
            // InternalVideoEdit.g:297:2: rule__Project__Group__2__Impl rule__Project__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Project__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__2"


    // $ANTLR start "rule__Project__Group__2__Impl"
    // InternalVideoEdit.g:304:1: rule__Project__Group__2__Impl : ( '{' ) ;
    public final void rule__Project__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:308:1: ( ( '{' ) )
            // InternalVideoEdit.g:309:1: ( '{' )
            {
            // InternalVideoEdit.g:309:1: ( '{' )
            // InternalVideoEdit.g:310:2: '{'
            {
             before(grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__2__Impl"


    // $ANTLR start "rule__Project__Group__3"
    // InternalVideoEdit.g:319:1: rule__Project__Group__3 : rule__Project__Group__3__Impl rule__Project__Group__4 ;
    public final void rule__Project__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:323:1: ( rule__Project__Group__3__Impl rule__Project__Group__4 )
            // InternalVideoEdit.g:324:2: rule__Project__Group__3__Impl rule__Project__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Project__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Project__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__3"


    // $ANTLR start "rule__Project__Group__3__Impl"
    // InternalVideoEdit.g:331:1: rule__Project__Group__3__Impl : ( ( rule__Project__TracksAssignment_3 )* ) ;
    public final void rule__Project__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:335:1: ( ( ( rule__Project__TracksAssignment_3 )* ) )
            // InternalVideoEdit.g:336:1: ( ( rule__Project__TracksAssignment_3 )* )
            {
            // InternalVideoEdit.g:336:1: ( ( rule__Project__TracksAssignment_3 )* )
            // InternalVideoEdit.g:337:2: ( rule__Project__TracksAssignment_3 )*
            {
             before(grammarAccess.getProjectAccess().getTracksAssignment_3()); 
            // InternalVideoEdit.g:338:2: ( rule__Project__TracksAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalVideoEdit.g:338:3: rule__Project__TracksAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Project__TracksAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getProjectAccess().getTracksAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__3__Impl"


    // $ANTLR start "rule__Project__Group__4"
    // InternalVideoEdit.g:346:1: rule__Project__Group__4 : rule__Project__Group__4__Impl ;
    public final void rule__Project__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:350:1: ( rule__Project__Group__4__Impl )
            // InternalVideoEdit.g:351:2: rule__Project__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Project__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__4"


    // $ANTLR start "rule__Project__Group__4__Impl"
    // InternalVideoEdit.g:357:1: rule__Project__Group__4__Impl : ( '}' ) ;
    public final void rule__Project__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:361:1: ( ( '}' ) )
            // InternalVideoEdit.g:362:1: ( '}' )
            {
            // InternalVideoEdit.g:362:1: ( '}' )
            // InternalVideoEdit.g:363:2: '}'
            {
             before(grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_4()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__Group__4__Impl"


    // $ANTLR start "rule__Track__Group__0"
    // InternalVideoEdit.g:373:1: rule__Track__Group__0 : rule__Track__Group__0__Impl rule__Track__Group__1 ;
    public final void rule__Track__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:377:1: ( rule__Track__Group__0__Impl rule__Track__Group__1 )
            // InternalVideoEdit.g:378:2: rule__Track__Group__0__Impl rule__Track__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Track__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Track__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__0"


    // $ANTLR start "rule__Track__Group__0__Impl"
    // InternalVideoEdit.g:385:1: rule__Track__Group__0__Impl : ( 'track' ) ;
    public final void rule__Track__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:389:1: ( ( 'track' ) )
            // InternalVideoEdit.g:390:1: ( 'track' )
            {
            // InternalVideoEdit.g:390:1: ( 'track' )
            // InternalVideoEdit.g:391:2: 'track'
            {
             before(grammarAccess.getTrackAccess().getTrackKeyword_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getTrackAccess().getTrackKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__0__Impl"


    // $ANTLR start "rule__Track__Group__1"
    // InternalVideoEdit.g:400:1: rule__Track__Group__1 : rule__Track__Group__1__Impl rule__Track__Group__2 ;
    public final void rule__Track__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:404:1: ( rule__Track__Group__1__Impl rule__Track__Group__2 )
            // InternalVideoEdit.g:405:2: rule__Track__Group__1__Impl rule__Track__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Track__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Track__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__1"


    // $ANTLR start "rule__Track__Group__1__Impl"
    // InternalVideoEdit.g:412:1: rule__Track__Group__1__Impl : ( ( rule__Track__TypeAssignment_1 ) ) ;
    public final void rule__Track__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:416:1: ( ( ( rule__Track__TypeAssignment_1 ) ) )
            // InternalVideoEdit.g:417:1: ( ( rule__Track__TypeAssignment_1 ) )
            {
            // InternalVideoEdit.g:417:1: ( ( rule__Track__TypeAssignment_1 ) )
            // InternalVideoEdit.g:418:2: ( rule__Track__TypeAssignment_1 )
            {
             before(grammarAccess.getTrackAccess().getTypeAssignment_1()); 
            // InternalVideoEdit.g:419:2: ( rule__Track__TypeAssignment_1 )
            // InternalVideoEdit.g:419:3: rule__Track__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Track__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrackAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__1__Impl"


    // $ANTLR start "rule__Track__Group__2"
    // InternalVideoEdit.g:427:1: rule__Track__Group__2 : rule__Track__Group__2__Impl rule__Track__Group__3 ;
    public final void rule__Track__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:431:1: ( rule__Track__Group__2__Impl rule__Track__Group__3 )
            // InternalVideoEdit.g:432:2: rule__Track__Group__2__Impl rule__Track__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Track__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Track__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__2"


    // $ANTLR start "rule__Track__Group__2__Impl"
    // InternalVideoEdit.g:439:1: rule__Track__Group__2__Impl : ( ( rule__Track__NameAssignment_2 ) ) ;
    public final void rule__Track__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:443:1: ( ( ( rule__Track__NameAssignment_2 ) ) )
            // InternalVideoEdit.g:444:1: ( ( rule__Track__NameAssignment_2 ) )
            {
            // InternalVideoEdit.g:444:1: ( ( rule__Track__NameAssignment_2 ) )
            // InternalVideoEdit.g:445:2: ( rule__Track__NameAssignment_2 )
            {
             before(grammarAccess.getTrackAccess().getNameAssignment_2()); 
            // InternalVideoEdit.g:446:2: ( rule__Track__NameAssignment_2 )
            // InternalVideoEdit.g:446:3: rule__Track__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Track__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTrackAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__2__Impl"


    // $ANTLR start "rule__Track__Group__3"
    // InternalVideoEdit.g:454:1: rule__Track__Group__3 : rule__Track__Group__3__Impl rule__Track__Group__4 ;
    public final void rule__Track__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:458:1: ( rule__Track__Group__3__Impl rule__Track__Group__4 )
            // InternalVideoEdit.g:459:2: rule__Track__Group__3__Impl rule__Track__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Track__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Track__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__3"


    // $ANTLR start "rule__Track__Group__3__Impl"
    // InternalVideoEdit.g:466:1: rule__Track__Group__3__Impl : ( '{' ) ;
    public final void rule__Track__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:470:1: ( ( '{' ) )
            // InternalVideoEdit.g:471:1: ( '{' )
            {
            // InternalVideoEdit.g:471:1: ( '{' )
            // InternalVideoEdit.g:472:2: '{'
            {
             before(grammarAccess.getTrackAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getTrackAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__3__Impl"


    // $ANTLR start "rule__Track__Group__4"
    // InternalVideoEdit.g:481:1: rule__Track__Group__4 : rule__Track__Group__4__Impl rule__Track__Group__5 ;
    public final void rule__Track__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:485:1: ( rule__Track__Group__4__Impl rule__Track__Group__5 )
            // InternalVideoEdit.g:486:2: rule__Track__Group__4__Impl rule__Track__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__Track__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Track__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__4"


    // $ANTLR start "rule__Track__Group__4__Impl"
    // InternalVideoEdit.g:493:1: rule__Track__Group__4__Impl : ( ( rule__Track__ClipsAssignment_4 )* ) ;
    public final void rule__Track__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:497:1: ( ( ( rule__Track__ClipsAssignment_4 )* ) )
            // InternalVideoEdit.g:498:1: ( ( rule__Track__ClipsAssignment_4 )* )
            {
            // InternalVideoEdit.g:498:1: ( ( rule__Track__ClipsAssignment_4 )* )
            // InternalVideoEdit.g:499:2: ( rule__Track__ClipsAssignment_4 )*
            {
             before(grammarAccess.getTrackAccess().getClipsAssignment_4()); 
            // InternalVideoEdit.g:500:2: ( rule__Track__ClipsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==21) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalVideoEdit.g:500:3: rule__Track__ClipsAssignment_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Track__ClipsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getTrackAccess().getClipsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__4__Impl"


    // $ANTLR start "rule__Track__Group__5"
    // InternalVideoEdit.g:508:1: rule__Track__Group__5 : rule__Track__Group__5__Impl ;
    public final void rule__Track__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:512:1: ( rule__Track__Group__5__Impl )
            // InternalVideoEdit.g:513:2: rule__Track__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Track__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__5"


    // $ANTLR start "rule__Track__Group__5__Impl"
    // InternalVideoEdit.g:519:1: rule__Track__Group__5__Impl : ( '}' ) ;
    public final void rule__Track__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:523:1: ( ( '}' ) )
            // InternalVideoEdit.g:524:1: ( '}' )
            {
            // InternalVideoEdit.g:524:1: ( '}' )
            // InternalVideoEdit.g:525:2: '}'
            {
             before(grammarAccess.getTrackAccess().getRightCurlyBracketKeyword_5()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getTrackAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__Group__5__Impl"


    // $ANTLR start "rule__Clip__Group__0"
    // InternalVideoEdit.g:535:1: rule__Clip__Group__0 : rule__Clip__Group__0__Impl rule__Clip__Group__1 ;
    public final void rule__Clip__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:539:1: ( rule__Clip__Group__0__Impl rule__Clip__Group__1 )
            // InternalVideoEdit.g:540:2: rule__Clip__Group__0__Impl rule__Clip__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Clip__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__0"


    // $ANTLR start "rule__Clip__Group__0__Impl"
    // InternalVideoEdit.g:547:1: rule__Clip__Group__0__Impl : ( 'clip' ) ;
    public final void rule__Clip__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:551:1: ( ( 'clip' ) )
            // InternalVideoEdit.g:552:1: ( 'clip' )
            {
            // InternalVideoEdit.g:552:1: ( 'clip' )
            // InternalVideoEdit.g:553:2: 'clip'
            {
             before(grammarAccess.getClipAccess().getClipKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getClipKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__0__Impl"


    // $ANTLR start "rule__Clip__Group__1"
    // InternalVideoEdit.g:562:1: rule__Clip__Group__1 : rule__Clip__Group__1__Impl rule__Clip__Group__2 ;
    public final void rule__Clip__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:566:1: ( rule__Clip__Group__1__Impl rule__Clip__Group__2 )
            // InternalVideoEdit.g:567:2: rule__Clip__Group__1__Impl rule__Clip__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Clip__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__1"


    // $ANTLR start "rule__Clip__Group__1__Impl"
    // InternalVideoEdit.g:574:1: rule__Clip__Group__1__Impl : ( ( rule__Clip__NameAssignment_1 ) ) ;
    public final void rule__Clip__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:578:1: ( ( ( rule__Clip__NameAssignment_1 ) ) )
            // InternalVideoEdit.g:579:1: ( ( rule__Clip__NameAssignment_1 ) )
            {
            // InternalVideoEdit.g:579:1: ( ( rule__Clip__NameAssignment_1 ) )
            // InternalVideoEdit.g:580:2: ( rule__Clip__NameAssignment_1 )
            {
             before(grammarAccess.getClipAccess().getNameAssignment_1()); 
            // InternalVideoEdit.g:581:2: ( rule__Clip__NameAssignment_1 )
            // InternalVideoEdit.g:581:3: rule__Clip__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Clip__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getClipAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__1__Impl"


    // $ANTLR start "rule__Clip__Group__2"
    // InternalVideoEdit.g:589:1: rule__Clip__Group__2 : rule__Clip__Group__2__Impl rule__Clip__Group__3 ;
    public final void rule__Clip__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:593:1: ( rule__Clip__Group__2__Impl rule__Clip__Group__3 )
            // InternalVideoEdit.g:594:2: rule__Clip__Group__2__Impl rule__Clip__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__Clip__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__2"


    // $ANTLR start "rule__Clip__Group__2__Impl"
    // InternalVideoEdit.g:601:1: rule__Clip__Group__2__Impl : ( '{' ) ;
    public final void rule__Clip__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:605:1: ( ( '{' ) )
            // InternalVideoEdit.g:606:1: ( '{' )
            {
            // InternalVideoEdit.g:606:1: ( '{' )
            // InternalVideoEdit.g:607:2: '{'
            {
             before(grammarAccess.getClipAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__2__Impl"


    // $ANTLR start "rule__Clip__Group__3"
    // InternalVideoEdit.g:616:1: rule__Clip__Group__3 : rule__Clip__Group__3__Impl rule__Clip__Group__4 ;
    public final void rule__Clip__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:620:1: ( rule__Clip__Group__3__Impl rule__Clip__Group__4 )
            // InternalVideoEdit.g:621:2: rule__Clip__Group__3__Impl rule__Clip__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__Clip__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__3"


    // $ANTLR start "rule__Clip__Group__3__Impl"
    // InternalVideoEdit.g:628:1: rule__Clip__Group__3__Impl : ( 'source:' ) ;
    public final void rule__Clip__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:632:1: ( ( 'source:' ) )
            // InternalVideoEdit.g:633:1: ( 'source:' )
            {
            // InternalVideoEdit.g:633:1: ( 'source:' )
            // InternalVideoEdit.g:634:2: 'source:'
            {
             before(grammarAccess.getClipAccess().getSourceKeyword_3()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getSourceKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__3__Impl"


    // $ANTLR start "rule__Clip__Group__4"
    // InternalVideoEdit.g:643:1: rule__Clip__Group__4 : rule__Clip__Group__4__Impl rule__Clip__Group__5 ;
    public final void rule__Clip__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:647:1: ( rule__Clip__Group__4__Impl rule__Clip__Group__5 )
            // InternalVideoEdit.g:648:2: rule__Clip__Group__4__Impl rule__Clip__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__Clip__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__4"


    // $ANTLR start "rule__Clip__Group__4__Impl"
    // InternalVideoEdit.g:655:1: rule__Clip__Group__4__Impl : ( ( rule__Clip__SourceAssignment_4 ) ) ;
    public final void rule__Clip__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:659:1: ( ( ( rule__Clip__SourceAssignment_4 ) ) )
            // InternalVideoEdit.g:660:1: ( ( rule__Clip__SourceAssignment_4 ) )
            {
            // InternalVideoEdit.g:660:1: ( ( rule__Clip__SourceAssignment_4 ) )
            // InternalVideoEdit.g:661:2: ( rule__Clip__SourceAssignment_4 )
            {
             before(grammarAccess.getClipAccess().getSourceAssignment_4()); 
            // InternalVideoEdit.g:662:2: ( rule__Clip__SourceAssignment_4 )
            // InternalVideoEdit.g:662:3: rule__Clip__SourceAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Clip__SourceAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getClipAccess().getSourceAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__4__Impl"


    // $ANTLR start "rule__Clip__Group__5"
    // InternalVideoEdit.g:670:1: rule__Clip__Group__5 : rule__Clip__Group__5__Impl rule__Clip__Group__6 ;
    public final void rule__Clip__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:674:1: ( rule__Clip__Group__5__Impl rule__Clip__Group__6 )
            // InternalVideoEdit.g:675:2: rule__Clip__Group__5__Impl rule__Clip__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__Clip__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__5"


    // $ANTLR start "rule__Clip__Group__5__Impl"
    // InternalVideoEdit.g:682:1: rule__Clip__Group__5__Impl : ( 'source_in:' ) ;
    public final void rule__Clip__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:686:1: ( ( 'source_in:' ) )
            // InternalVideoEdit.g:687:1: ( 'source_in:' )
            {
            // InternalVideoEdit.g:687:1: ( 'source_in:' )
            // InternalVideoEdit.g:688:2: 'source_in:'
            {
             before(grammarAccess.getClipAccess().getSource_inKeyword_5()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getSource_inKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__5__Impl"


    // $ANTLR start "rule__Clip__Group__6"
    // InternalVideoEdit.g:697:1: rule__Clip__Group__6 : rule__Clip__Group__6__Impl rule__Clip__Group__7 ;
    public final void rule__Clip__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:701:1: ( rule__Clip__Group__6__Impl rule__Clip__Group__7 )
            // InternalVideoEdit.g:702:2: rule__Clip__Group__6__Impl rule__Clip__Group__7
            {
            pushFollow(FOLLOW_14);
            rule__Clip__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__6"


    // $ANTLR start "rule__Clip__Group__6__Impl"
    // InternalVideoEdit.g:709:1: rule__Clip__Group__6__Impl : ( ( rule__Clip__SourceInAssignment_6 ) ) ;
    public final void rule__Clip__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:713:1: ( ( ( rule__Clip__SourceInAssignment_6 ) ) )
            // InternalVideoEdit.g:714:1: ( ( rule__Clip__SourceInAssignment_6 ) )
            {
            // InternalVideoEdit.g:714:1: ( ( rule__Clip__SourceInAssignment_6 ) )
            // InternalVideoEdit.g:715:2: ( rule__Clip__SourceInAssignment_6 )
            {
             before(grammarAccess.getClipAccess().getSourceInAssignment_6()); 
            // InternalVideoEdit.g:716:2: ( rule__Clip__SourceInAssignment_6 )
            // InternalVideoEdit.g:716:3: rule__Clip__SourceInAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Clip__SourceInAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getClipAccess().getSourceInAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__6__Impl"


    // $ANTLR start "rule__Clip__Group__7"
    // InternalVideoEdit.g:724:1: rule__Clip__Group__7 : rule__Clip__Group__7__Impl rule__Clip__Group__8 ;
    public final void rule__Clip__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:728:1: ( rule__Clip__Group__7__Impl rule__Clip__Group__8 )
            // InternalVideoEdit.g:729:2: rule__Clip__Group__7__Impl rule__Clip__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__Clip__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__7"


    // $ANTLR start "rule__Clip__Group__7__Impl"
    // InternalVideoEdit.g:736:1: rule__Clip__Group__7__Impl : ( 'source_out:' ) ;
    public final void rule__Clip__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:740:1: ( ( 'source_out:' ) )
            // InternalVideoEdit.g:741:1: ( 'source_out:' )
            {
            // InternalVideoEdit.g:741:1: ( 'source_out:' )
            // InternalVideoEdit.g:742:2: 'source_out:'
            {
             before(grammarAccess.getClipAccess().getSource_outKeyword_7()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getSource_outKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__7__Impl"


    // $ANTLR start "rule__Clip__Group__8"
    // InternalVideoEdit.g:751:1: rule__Clip__Group__8 : rule__Clip__Group__8__Impl rule__Clip__Group__9 ;
    public final void rule__Clip__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:755:1: ( rule__Clip__Group__8__Impl rule__Clip__Group__9 )
            // InternalVideoEdit.g:756:2: rule__Clip__Group__8__Impl rule__Clip__Group__9
            {
            pushFollow(FOLLOW_15);
            rule__Clip__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__8"


    // $ANTLR start "rule__Clip__Group__8__Impl"
    // InternalVideoEdit.g:763:1: rule__Clip__Group__8__Impl : ( ( rule__Clip__SourceOutAssignment_8 ) ) ;
    public final void rule__Clip__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:767:1: ( ( ( rule__Clip__SourceOutAssignment_8 ) ) )
            // InternalVideoEdit.g:768:1: ( ( rule__Clip__SourceOutAssignment_8 ) )
            {
            // InternalVideoEdit.g:768:1: ( ( rule__Clip__SourceOutAssignment_8 ) )
            // InternalVideoEdit.g:769:2: ( rule__Clip__SourceOutAssignment_8 )
            {
             before(grammarAccess.getClipAccess().getSourceOutAssignment_8()); 
            // InternalVideoEdit.g:770:2: ( rule__Clip__SourceOutAssignment_8 )
            // InternalVideoEdit.g:770:3: rule__Clip__SourceOutAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Clip__SourceOutAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getClipAccess().getSourceOutAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__8__Impl"


    // $ANTLR start "rule__Clip__Group__9"
    // InternalVideoEdit.g:778:1: rule__Clip__Group__9 : rule__Clip__Group__9__Impl rule__Clip__Group__10 ;
    public final void rule__Clip__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:782:1: ( rule__Clip__Group__9__Impl rule__Clip__Group__10 )
            // InternalVideoEdit.g:783:2: rule__Clip__Group__9__Impl rule__Clip__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__Clip__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__9"


    // $ANTLR start "rule__Clip__Group__9__Impl"
    // InternalVideoEdit.g:790:1: rule__Clip__Group__9__Impl : ( 'target_position:' ) ;
    public final void rule__Clip__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:794:1: ( ( 'target_position:' ) )
            // InternalVideoEdit.g:795:1: ( 'target_position:' )
            {
            // InternalVideoEdit.g:795:1: ( 'target_position:' )
            // InternalVideoEdit.g:796:2: 'target_position:'
            {
             before(grammarAccess.getClipAccess().getTarget_positionKeyword_9()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getTarget_positionKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__9__Impl"


    // $ANTLR start "rule__Clip__Group__10"
    // InternalVideoEdit.g:805:1: rule__Clip__Group__10 : rule__Clip__Group__10__Impl rule__Clip__Group__11 ;
    public final void rule__Clip__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:809:1: ( rule__Clip__Group__10__Impl rule__Clip__Group__11 )
            // InternalVideoEdit.g:810:2: rule__Clip__Group__10__Impl rule__Clip__Group__11
            {
            pushFollow(FOLLOW_16);
            rule__Clip__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__10"


    // $ANTLR start "rule__Clip__Group__10__Impl"
    // InternalVideoEdit.g:817:1: rule__Clip__Group__10__Impl : ( ( rule__Clip__TargetPositionAssignment_10 ) ) ;
    public final void rule__Clip__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:821:1: ( ( ( rule__Clip__TargetPositionAssignment_10 ) ) )
            // InternalVideoEdit.g:822:1: ( ( rule__Clip__TargetPositionAssignment_10 ) )
            {
            // InternalVideoEdit.g:822:1: ( ( rule__Clip__TargetPositionAssignment_10 ) )
            // InternalVideoEdit.g:823:2: ( rule__Clip__TargetPositionAssignment_10 )
            {
             before(grammarAccess.getClipAccess().getTargetPositionAssignment_10()); 
            // InternalVideoEdit.g:824:2: ( rule__Clip__TargetPositionAssignment_10 )
            // InternalVideoEdit.g:824:3: rule__Clip__TargetPositionAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Clip__TargetPositionAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getClipAccess().getTargetPositionAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__10__Impl"


    // $ANTLR start "rule__Clip__Group__11"
    // InternalVideoEdit.g:832:1: rule__Clip__Group__11 : rule__Clip__Group__11__Impl rule__Clip__Group__12 ;
    public final void rule__Clip__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:836:1: ( rule__Clip__Group__11__Impl rule__Clip__Group__12 )
            // InternalVideoEdit.g:837:2: rule__Clip__Group__11__Impl rule__Clip__Group__12
            {
            pushFollow(FOLLOW_16);
            rule__Clip__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__11"


    // $ANTLR start "rule__Clip__Group__11__Impl"
    // InternalVideoEdit.g:844:1: rule__Clip__Group__11__Impl : ( ( rule__Clip__AudioLevelAssignment_11 )? ) ;
    public final void rule__Clip__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:848:1: ( ( ( rule__Clip__AudioLevelAssignment_11 )? ) )
            // InternalVideoEdit.g:849:1: ( ( rule__Clip__AudioLevelAssignment_11 )? )
            {
            // InternalVideoEdit.g:849:1: ( ( rule__Clip__AudioLevelAssignment_11 )? )
            // InternalVideoEdit.g:850:2: ( rule__Clip__AudioLevelAssignment_11 )?
            {
             before(grammarAccess.getClipAccess().getAudioLevelAssignment_11()); 
            // InternalVideoEdit.g:851:2: ( rule__Clip__AudioLevelAssignment_11 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==27) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalVideoEdit.g:851:3: rule__Clip__AudioLevelAssignment_11
                    {
                    pushFollow(FOLLOW_2);
                    rule__Clip__AudioLevelAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClipAccess().getAudioLevelAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__11__Impl"


    // $ANTLR start "rule__Clip__Group__12"
    // InternalVideoEdit.g:859:1: rule__Clip__Group__12 : rule__Clip__Group__12__Impl rule__Clip__Group__13 ;
    public final void rule__Clip__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:863:1: ( rule__Clip__Group__12__Impl rule__Clip__Group__13 )
            // InternalVideoEdit.g:864:2: rule__Clip__Group__12__Impl rule__Clip__Group__13
            {
            pushFollow(FOLLOW_16);
            rule__Clip__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__12"


    // $ANTLR start "rule__Clip__Group__12__Impl"
    // InternalVideoEdit.g:871:1: rule__Clip__Group__12__Impl : ( ( rule__Clip__Group_12__0 )? ) ;
    public final void rule__Clip__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:875:1: ( ( ( rule__Clip__Group_12__0 )? ) )
            // InternalVideoEdit.g:876:1: ( ( rule__Clip__Group_12__0 )? )
            {
            // InternalVideoEdit.g:876:1: ( ( rule__Clip__Group_12__0 )? )
            // InternalVideoEdit.g:877:2: ( rule__Clip__Group_12__0 )?
            {
             before(grammarAccess.getClipAccess().getGroup_12()); 
            // InternalVideoEdit.g:878:2: ( rule__Clip__Group_12__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==26) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalVideoEdit.g:878:3: rule__Clip__Group_12__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Clip__Group_12__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClipAccess().getGroup_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__12__Impl"


    // $ANTLR start "rule__Clip__Group__13"
    // InternalVideoEdit.g:886:1: rule__Clip__Group__13 : rule__Clip__Group__13__Impl ;
    public final void rule__Clip__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:890:1: ( rule__Clip__Group__13__Impl )
            // InternalVideoEdit.g:891:2: rule__Clip__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Clip__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__13"


    // $ANTLR start "rule__Clip__Group__13__Impl"
    // InternalVideoEdit.g:897:1: rule__Clip__Group__13__Impl : ( '}' ) ;
    public final void rule__Clip__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:901:1: ( ( '}' ) )
            // InternalVideoEdit.g:902:1: ( '}' )
            {
            // InternalVideoEdit.g:902:1: ( '}' )
            // InternalVideoEdit.g:903:2: '}'
            {
             before(grammarAccess.getClipAccess().getRightCurlyBracketKeyword_13()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getRightCurlyBracketKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group__13__Impl"


    // $ANTLR start "rule__Clip__Group_12__0"
    // InternalVideoEdit.g:913:1: rule__Clip__Group_12__0 : rule__Clip__Group_12__0__Impl rule__Clip__Group_12__1 ;
    public final void rule__Clip__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:917:1: ( rule__Clip__Group_12__0__Impl rule__Clip__Group_12__1 )
            // InternalVideoEdit.g:918:2: rule__Clip__Group_12__0__Impl rule__Clip__Group_12__1
            {
            pushFollow(FOLLOW_3);
            rule__Clip__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Clip__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group_12__0"


    // $ANTLR start "rule__Clip__Group_12__0__Impl"
    // InternalVideoEdit.g:925:1: rule__Clip__Group_12__0__Impl : ( 'sync_with:' ) ;
    public final void rule__Clip__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:929:1: ( ( 'sync_with:' ) )
            // InternalVideoEdit.g:930:1: ( 'sync_with:' )
            {
            // InternalVideoEdit.g:930:1: ( 'sync_with:' )
            // InternalVideoEdit.g:931:2: 'sync_with:'
            {
             before(grammarAccess.getClipAccess().getSync_withKeyword_12_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getSync_withKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group_12__0__Impl"


    // $ANTLR start "rule__Clip__Group_12__1"
    // InternalVideoEdit.g:940:1: rule__Clip__Group_12__1 : rule__Clip__Group_12__1__Impl ;
    public final void rule__Clip__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:944:1: ( rule__Clip__Group_12__1__Impl )
            // InternalVideoEdit.g:945:2: rule__Clip__Group_12__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Clip__Group_12__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group_12__1"


    // $ANTLR start "rule__Clip__Group_12__1__Impl"
    // InternalVideoEdit.g:951:1: rule__Clip__Group_12__1__Impl : ( ( rule__Clip__SyncWithAssignment_12_1 ) ) ;
    public final void rule__Clip__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:955:1: ( ( ( rule__Clip__SyncWithAssignment_12_1 ) ) )
            // InternalVideoEdit.g:956:1: ( ( rule__Clip__SyncWithAssignment_12_1 ) )
            {
            // InternalVideoEdit.g:956:1: ( ( rule__Clip__SyncWithAssignment_12_1 ) )
            // InternalVideoEdit.g:957:2: ( rule__Clip__SyncWithAssignment_12_1 )
            {
             before(grammarAccess.getClipAccess().getSyncWithAssignment_12_1()); 
            // InternalVideoEdit.g:958:2: ( rule__Clip__SyncWithAssignment_12_1 )
            // InternalVideoEdit.g:958:3: rule__Clip__SyncWithAssignment_12_1
            {
            pushFollow(FOLLOW_2);
            rule__Clip__SyncWithAssignment_12_1();

            state._fsp--;


            }

             after(grammarAccess.getClipAccess().getSyncWithAssignment_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__Group_12__1__Impl"


    // $ANTLR start "rule__AudioLevel__Group__0"
    // InternalVideoEdit.g:967:1: rule__AudioLevel__Group__0 : rule__AudioLevel__Group__0__Impl rule__AudioLevel__Group__1 ;
    public final void rule__AudioLevel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:971:1: ( rule__AudioLevel__Group__0__Impl rule__AudioLevel__Group__1 )
            // InternalVideoEdit.g:972:2: rule__AudioLevel__Group__0__Impl rule__AudioLevel__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__AudioLevel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AudioLevel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AudioLevel__Group__0"


    // $ANTLR start "rule__AudioLevel__Group__0__Impl"
    // InternalVideoEdit.g:979:1: rule__AudioLevel__Group__0__Impl : ( 'audio_level:' ) ;
    public final void rule__AudioLevel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:983:1: ( ( 'audio_level:' ) )
            // InternalVideoEdit.g:984:1: ( 'audio_level:' )
            {
            // InternalVideoEdit.g:984:1: ( 'audio_level:' )
            // InternalVideoEdit.g:985:2: 'audio_level:'
            {
             before(grammarAccess.getAudioLevelAccess().getAudio_levelKeyword_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getAudioLevelAccess().getAudio_levelKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AudioLevel__Group__0__Impl"


    // $ANTLR start "rule__AudioLevel__Group__1"
    // InternalVideoEdit.g:994:1: rule__AudioLevel__Group__1 : rule__AudioLevel__Group__1__Impl rule__AudioLevel__Group__2 ;
    public final void rule__AudioLevel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:998:1: ( rule__AudioLevel__Group__1__Impl rule__AudioLevel__Group__2 )
            // InternalVideoEdit.g:999:2: rule__AudioLevel__Group__1__Impl rule__AudioLevel__Group__2
            {
            pushFollow(FOLLOW_17);
            rule__AudioLevel__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AudioLevel__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AudioLevel__Group__1"


    // $ANTLR start "rule__AudioLevel__Group__1__Impl"
    // InternalVideoEdit.g:1006:1: rule__AudioLevel__Group__1__Impl : ( ( rule__AudioLevel__LevelAssignment_1 ) ) ;
    public final void rule__AudioLevel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1010:1: ( ( ( rule__AudioLevel__LevelAssignment_1 ) ) )
            // InternalVideoEdit.g:1011:1: ( ( rule__AudioLevel__LevelAssignment_1 ) )
            {
            // InternalVideoEdit.g:1011:1: ( ( rule__AudioLevel__LevelAssignment_1 ) )
            // InternalVideoEdit.g:1012:2: ( rule__AudioLevel__LevelAssignment_1 )
            {
             before(grammarAccess.getAudioLevelAccess().getLevelAssignment_1()); 
            // InternalVideoEdit.g:1013:2: ( rule__AudioLevel__LevelAssignment_1 )
            // InternalVideoEdit.g:1013:3: rule__AudioLevel__LevelAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AudioLevel__LevelAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAudioLevelAccess().getLevelAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AudioLevel__Group__1__Impl"


    // $ANTLR start "rule__AudioLevel__Group__2"
    // InternalVideoEdit.g:1021:1: rule__AudioLevel__Group__2 : rule__AudioLevel__Group__2__Impl ;
    public final void rule__AudioLevel__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1025:1: ( rule__AudioLevel__Group__2__Impl )
            // InternalVideoEdit.g:1026:2: rule__AudioLevel__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AudioLevel__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AudioLevel__Group__2"


    // $ANTLR start "rule__AudioLevel__Group__2__Impl"
    // InternalVideoEdit.g:1032:1: rule__AudioLevel__Group__2__Impl : ( '%' ) ;
    public final void rule__AudioLevel__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1036:1: ( ( '%' ) )
            // InternalVideoEdit.g:1037:1: ( '%' )
            {
            // InternalVideoEdit.g:1037:1: ( '%' )
            // InternalVideoEdit.g:1038:2: '%'
            {
             before(grammarAccess.getAudioLevelAccess().getPercentSignKeyword_2()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getAudioLevelAccess().getPercentSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AudioLevel__Group__2__Impl"


    // $ANTLR start "rule__TimeCode__Group__0"
    // InternalVideoEdit.g:1048:1: rule__TimeCode__Group__0 : rule__TimeCode__Group__0__Impl rule__TimeCode__Group__1 ;
    public final void rule__TimeCode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1052:1: ( rule__TimeCode__Group__0__Impl rule__TimeCode__Group__1 )
            // InternalVideoEdit.g:1053:2: rule__TimeCode__Group__0__Impl rule__TimeCode__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__TimeCode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeCode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__0"


    // $ANTLR start "rule__TimeCode__Group__0__Impl"
    // InternalVideoEdit.g:1060:1: rule__TimeCode__Group__0__Impl : ( ( rule__TimeCode__HoursAssignment_0 ) ) ;
    public final void rule__TimeCode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1064:1: ( ( ( rule__TimeCode__HoursAssignment_0 ) ) )
            // InternalVideoEdit.g:1065:1: ( ( rule__TimeCode__HoursAssignment_0 ) )
            {
            // InternalVideoEdit.g:1065:1: ( ( rule__TimeCode__HoursAssignment_0 ) )
            // InternalVideoEdit.g:1066:2: ( rule__TimeCode__HoursAssignment_0 )
            {
             before(grammarAccess.getTimeCodeAccess().getHoursAssignment_0()); 
            // InternalVideoEdit.g:1067:2: ( rule__TimeCode__HoursAssignment_0 )
            // InternalVideoEdit.g:1067:3: rule__TimeCode__HoursAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TimeCode__HoursAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTimeCodeAccess().getHoursAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__0__Impl"


    // $ANTLR start "rule__TimeCode__Group__1"
    // InternalVideoEdit.g:1075:1: rule__TimeCode__Group__1 : rule__TimeCode__Group__1__Impl rule__TimeCode__Group__2 ;
    public final void rule__TimeCode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1079:1: ( rule__TimeCode__Group__1__Impl rule__TimeCode__Group__2 )
            // InternalVideoEdit.g:1080:2: rule__TimeCode__Group__1__Impl rule__TimeCode__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__TimeCode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeCode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__1"


    // $ANTLR start "rule__TimeCode__Group__1__Impl"
    // InternalVideoEdit.g:1087:1: rule__TimeCode__Group__1__Impl : ( ':' ) ;
    public final void rule__TimeCode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1091:1: ( ( ':' ) )
            // InternalVideoEdit.g:1092:1: ( ':' )
            {
            // InternalVideoEdit.g:1092:1: ( ':' )
            // InternalVideoEdit.g:1093:2: ':'
            {
             before(grammarAccess.getTimeCodeAccess().getColonKeyword_1()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getTimeCodeAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__1__Impl"


    // $ANTLR start "rule__TimeCode__Group__2"
    // InternalVideoEdit.g:1102:1: rule__TimeCode__Group__2 : rule__TimeCode__Group__2__Impl rule__TimeCode__Group__3 ;
    public final void rule__TimeCode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1106:1: ( rule__TimeCode__Group__2__Impl rule__TimeCode__Group__3 )
            // InternalVideoEdit.g:1107:2: rule__TimeCode__Group__2__Impl rule__TimeCode__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__TimeCode__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeCode__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__2"


    // $ANTLR start "rule__TimeCode__Group__2__Impl"
    // InternalVideoEdit.g:1114:1: rule__TimeCode__Group__2__Impl : ( ( rule__TimeCode__MinutesAssignment_2 ) ) ;
    public final void rule__TimeCode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1118:1: ( ( ( rule__TimeCode__MinutesAssignment_2 ) ) )
            // InternalVideoEdit.g:1119:1: ( ( rule__TimeCode__MinutesAssignment_2 ) )
            {
            // InternalVideoEdit.g:1119:1: ( ( rule__TimeCode__MinutesAssignment_2 ) )
            // InternalVideoEdit.g:1120:2: ( rule__TimeCode__MinutesAssignment_2 )
            {
             before(grammarAccess.getTimeCodeAccess().getMinutesAssignment_2()); 
            // InternalVideoEdit.g:1121:2: ( rule__TimeCode__MinutesAssignment_2 )
            // InternalVideoEdit.g:1121:3: rule__TimeCode__MinutesAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TimeCode__MinutesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTimeCodeAccess().getMinutesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__2__Impl"


    // $ANTLR start "rule__TimeCode__Group__3"
    // InternalVideoEdit.g:1129:1: rule__TimeCode__Group__3 : rule__TimeCode__Group__3__Impl rule__TimeCode__Group__4 ;
    public final void rule__TimeCode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1133:1: ( rule__TimeCode__Group__3__Impl rule__TimeCode__Group__4 )
            // InternalVideoEdit.g:1134:2: rule__TimeCode__Group__3__Impl rule__TimeCode__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__TimeCode__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeCode__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__3"


    // $ANTLR start "rule__TimeCode__Group__3__Impl"
    // InternalVideoEdit.g:1141:1: rule__TimeCode__Group__3__Impl : ( ':' ) ;
    public final void rule__TimeCode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1145:1: ( ( ':' ) )
            // InternalVideoEdit.g:1146:1: ( ':' )
            {
            // InternalVideoEdit.g:1146:1: ( ':' )
            // InternalVideoEdit.g:1147:2: ':'
            {
             before(grammarAccess.getTimeCodeAccess().getColonKeyword_3()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getTimeCodeAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__3__Impl"


    // $ANTLR start "rule__TimeCode__Group__4"
    // InternalVideoEdit.g:1156:1: rule__TimeCode__Group__4 : rule__TimeCode__Group__4__Impl rule__TimeCode__Group__5 ;
    public final void rule__TimeCode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1160:1: ( rule__TimeCode__Group__4__Impl rule__TimeCode__Group__5 )
            // InternalVideoEdit.g:1161:2: rule__TimeCode__Group__4__Impl rule__TimeCode__Group__5
            {
            pushFollow(FOLLOW_18);
            rule__TimeCode__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeCode__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__4"


    // $ANTLR start "rule__TimeCode__Group__4__Impl"
    // InternalVideoEdit.g:1168:1: rule__TimeCode__Group__4__Impl : ( ( rule__TimeCode__SecondsAssignment_4 ) ) ;
    public final void rule__TimeCode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1172:1: ( ( ( rule__TimeCode__SecondsAssignment_4 ) ) )
            // InternalVideoEdit.g:1173:1: ( ( rule__TimeCode__SecondsAssignment_4 ) )
            {
            // InternalVideoEdit.g:1173:1: ( ( rule__TimeCode__SecondsAssignment_4 ) )
            // InternalVideoEdit.g:1174:2: ( rule__TimeCode__SecondsAssignment_4 )
            {
             before(grammarAccess.getTimeCodeAccess().getSecondsAssignment_4()); 
            // InternalVideoEdit.g:1175:2: ( rule__TimeCode__SecondsAssignment_4 )
            // InternalVideoEdit.g:1175:3: rule__TimeCode__SecondsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TimeCode__SecondsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTimeCodeAccess().getSecondsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__4__Impl"


    // $ANTLR start "rule__TimeCode__Group__5"
    // InternalVideoEdit.g:1183:1: rule__TimeCode__Group__5 : rule__TimeCode__Group__5__Impl rule__TimeCode__Group__6 ;
    public final void rule__TimeCode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1187:1: ( rule__TimeCode__Group__5__Impl rule__TimeCode__Group__6 )
            // InternalVideoEdit.g:1188:2: rule__TimeCode__Group__5__Impl rule__TimeCode__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__TimeCode__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeCode__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__5"


    // $ANTLR start "rule__TimeCode__Group__5__Impl"
    // InternalVideoEdit.g:1195:1: rule__TimeCode__Group__5__Impl : ( ':' ) ;
    public final void rule__TimeCode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1199:1: ( ( ':' ) )
            // InternalVideoEdit.g:1200:1: ( ':' )
            {
            // InternalVideoEdit.g:1200:1: ( ':' )
            // InternalVideoEdit.g:1201:2: ':'
            {
             before(grammarAccess.getTimeCodeAccess().getColonKeyword_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getTimeCodeAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__5__Impl"


    // $ANTLR start "rule__TimeCode__Group__6"
    // InternalVideoEdit.g:1210:1: rule__TimeCode__Group__6 : rule__TimeCode__Group__6__Impl ;
    public final void rule__TimeCode__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1214:1: ( rule__TimeCode__Group__6__Impl )
            // InternalVideoEdit.g:1215:2: rule__TimeCode__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TimeCode__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__6"


    // $ANTLR start "rule__TimeCode__Group__6__Impl"
    // InternalVideoEdit.g:1221:1: rule__TimeCode__Group__6__Impl : ( ( rule__TimeCode__FramesAssignment_6 ) ) ;
    public final void rule__TimeCode__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1225:1: ( ( ( rule__TimeCode__FramesAssignment_6 ) ) )
            // InternalVideoEdit.g:1226:1: ( ( rule__TimeCode__FramesAssignment_6 ) )
            {
            // InternalVideoEdit.g:1226:1: ( ( rule__TimeCode__FramesAssignment_6 ) )
            // InternalVideoEdit.g:1227:2: ( rule__TimeCode__FramesAssignment_6 )
            {
             before(grammarAccess.getTimeCodeAccess().getFramesAssignment_6()); 
            // InternalVideoEdit.g:1228:2: ( rule__TimeCode__FramesAssignment_6 )
            // InternalVideoEdit.g:1228:3: rule__TimeCode__FramesAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__TimeCode__FramesAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getTimeCodeAccess().getFramesAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__Group__6__Impl"


    // $ANTLR start "rule__Project__NameAssignment_1"
    // InternalVideoEdit.g:1237:1: rule__Project__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Project__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1241:1: ( ( RULE_STRING ) )
            // InternalVideoEdit.g:1242:2: ( RULE_STRING )
            {
            // InternalVideoEdit.g:1242:2: ( RULE_STRING )
            // InternalVideoEdit.g:1243:3: RULE_STRING
            {
             before(grammarAccess.getProjectAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getProjectAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__NameAssignment_1"


    // $ANTLR start "rule__Project__TracksAssignment_3"
    // InternalVideoEdit.g:1252:1: rule__Project__TracksAssignment_3 : ( ruleTrack ) ;
    public final void rule__Project__TracksAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1256:1: ( ( ruleTrack ) )
            // InternalVideoEdit.g:1257:2: ( ruleTrack )
            {
            // InternalVideoEdit.g:1257:2: ( ruleTrack )
            // InternalVideoEdit.g:1258:3: ruleTrack
            {
             before(grammarAccess.getProjectAccess().getTracksTrackParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTrack();

            state._fsp--;

             after(grammarAccess.getProjectAccess().getTracksTrackParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Project__TracksAssignment_3"


    // $ANTLR start "rule__Track__TypeAssignment_1"
    // InternalVideoEdit.g:1267:1: rule__Track__TypeAssignment_1 : ( ruleTrackType ) ;
    public final void rule__Track__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1271:1: ( ( ruleTrackType ) )
            // InternalVideoEdit.g:1272:2: ( ruleTrackType )
            {
            // InternalVideoEdit.g:1272:2: ( ruleTrackType )
            // InternalVideoEdit.g:1273:3: ruleTrackType
            {
             before(grammarAccess.getTrackAccess().getTypeTrackTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTrackType();

            state._fsp--;

             after(grammarAccess.getTrackAccess().getTypeTrackTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__TypeAssignment_1"


    // $ANTLR start "rule__Track__NameAssignment_2"
    // InternalVideoEdit.g:1282:1: rule__Track__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Track__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1286:1: ( ( RULE_ID ) )
            // InternalVideoEdit.g:1287:2: ( RULE_ID )
            {
            // InternalVideoEdit.g:1287:2: ( RULE_ID )
            // InternalVideoEdit.g:1288:3: RULE_ID
            {
             before(grammarAccess.getTrackAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTrackAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__NameAssignment_2"


    // $ANTLR start "rule__Track__ClipsAssignment_4"
    // InternalVideoEdit.g:1297:1: rule__Track__ClipsAssignment_4 : ( ruleClip ) ;
    public final void rule__Track__ClipsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1301:1: ( ( ruleClip ) )
            // InternalVideoEdit.g:1302:2: ( ruleClip )
            {
            // InternalVideoEdit.g:1302:2: ( ruleClip )
            // InternalVideoEdit.g:1303:3: ruleClip
            {
             before(grammarAccess.getTrackAccess().getClipsClipParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleClip();

            state._fsp--;

             after(grammarAccess.getTrackAccess().getClipsClipParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Track__ClipsAssignment_4"


    // $ANTLR start "rule__Clip__NameAssignment_1"
    // InternalVideoEdit.g:1312:1: rule__Clip__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Clip__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1316:1: ( ( RULE_STRING ) )
            // InternalVideoEdit.g:1317:2: ( RULE_STRING )
            {
            // InternalVideoEdit.g:1317:2: ( RULE_STRING )
            // InternalVideoEdit.g:1318:3: RULE_STRING
            {
             before(grammarAccess.getClipAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__NameAssignment_1"


    // $ANTLR start "rule__Clip__SourceAssignment_4"
    // InternalVideoEdit.g:1327:1: rule__Clip__SourceAssignment_4 : ( RULE_STRING ) ;
    public final void rule__Clip__SourceAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1331:1: ( ( RULE_STRING ) )
            // InternalVideoEdit.g:1332:2: ( RULE_STRING )
            {
            // InternalVideoEdit.g:1332:2: ( RULE_STRING )
            // InternalVideoEdit.g:1333:3: RULE_STRING
            {
             before(grammarAccess.getClipAccess().getSourceSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getSourceSTRINGTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__SourceAssignment_4"


    // $ANTLR start "rule__Clip__SourceInAssignment_6"
    // InternalVideoEdit.g:1342:1: rule__Clip__SourceInAssignment_6 : ( ruleTimeCode ) ;
    public final void rule__Clip__SourceInAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1346:1: ( ( ruleTimeCode ) )
            // InternalVideoEdit.g:1347:2: ( ruleTimeCode )
            {
            // InternalVideoEdit.g:1347:2: ( ruleTimeCode )
            // InternalVideoEdit.g:1348:3: ruleTimeCode
            {
             before(grammarAccess.getClipAccess().getSourceInTimeCodeParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeCode();

            state._fsp--;

             after(grammarAccess.getClipAccess().getSourceInTimeCodeParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__SourceInAssignment_6"


    // $ANTLR start "rule__Clip__SourceOutAssignment_8"
    // InternalVideoEdit.g:1357:1: rule__Clip__SourceOutAssignment_8 : ( ruleTimeCode ) ;
    public final void rule__Clip__SourceOutAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1361:1: ( ( ruleTimeCode ) )
            // InternalVideoEdit.g:1362:2: ( ruleTimeCode )
            {
            // InternalVideoEdit.g:1362:2: ( ruleTimeCode )
            // InternalVideoEdit.g:1363:3: ruleTimeCode
            {
             before(grammarAccess.getClipAccess().getSourceOutTimeCodeParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeCode();

            state._fsp--;

             after(grammarAccess.getClipAccess().getSourceOutTimeCodeParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__SourceOutAssignment_8"


    // $ANTLR start "rule__Clip__TargetPositionAssignment_10"
    // InternalVideoEdit.g:1372:1: rule__Clip__TargetPositionAssignment_10 : ( ruleTimeCode ) ;
    public final void rule__Clip__TargetPositionAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1376:1: ( ( ruleTimeCode ) )
            // InternalVideoEdit.g:1377:2: ( ruleTimeCode )
            {
            // InternalVideoEdit.g:1377:2: ( ruleTimeCode )
            // InternalVideoEdit.g:1378:3: ruleTimeCode
            {
             before(grammarAccess.getClipAccess().getTargetPositionTimeCodeParserRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeCode();

            state._fsp--;

             after(grammarAccess.getClipAccess().getTargetPositionTimeCodeParserRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__TargetPositionAssignment_10"


    // $ANTLR start "rule__Clip__AudioLevelAssignment_11"
    // InternalVideoEdit.g:1387:1: rule__Clip__AudioLevelAssignment_11 : ( ruleAudioLevel ) ;
    public final void rule__Clip__AudioLevelAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1391:1: ( ( ruleAudioLevel ) )
            // InternalVideoEdit.g:1392:2: ( ruleAudioLevel )
            {
            // InternalVideoEdit.g:1392:2: ( ruleAudioLevel )
            // InternalVideoEdit.g:1393:3: ruleAudioLevel
            {
             before(grammarAccess.getClipAccess().getAudioLevelAudioLevelParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleAudioLevel();

            state._fsp--;

             after(grammarAccess.getClipAccess().getAudioLevelAudioLevelParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__AudioLevelAssignment_11"


    // $ANTLR start "rule__Clip__SyncWithAssignment_12_1"
    // InternalVideoEdit.g:1402:1: rule__Clip__SyncWithAssignment_12_1 : ( ( RULE_STRING ) ) ;
    public final void rule__Clip__SyncWithAssignment_12_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1406:1: ( ( ( RULE_STRING ) ) )
            // InternalVideoEdit.g:1407:2: ( ( RULE_STRING ) )
            {
            // InternalVideoEdit.g:1407:2: ( ( RULE_STRING ) )
            // InternalVideoEdit.g:1408:3: ( RULE_STRING )
            {
             before(grammarAccess.getClipAccess().getSyncWithClipCrossReference_12_1_0()); 
            // InternalVideoEdit.g:1409:3: ( RULE_STRING )
            // InternalVideoEdit.g:1410:4: RULE_STRING
            {
             before(grammarAccess.getClipAccess().getSyncWithClipSTRINGTerminalRuleCall_12_1_0_1()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getClipAccess().getSyncWithClipSTRINGTerminalRuleCall_12_1_0_1()); 

            }

             after(grammarAccess.getClipAccess().getSyncWithClipCrossReference_12_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Clip__SyncWithAssignment_12_1"


    // $ANTLR start "rule__AudioLevel__LevelAssignment_1"
    // InternalVideoEdit.g:1421:1: rule__AudioLevel__LevelAssignment_1 : ( RULE_INT ) ;
    public final void rule__AudioLevel__LevelAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1425:1: ( ( RULE_INT ) )
            // InternalVideoEdit.g:1426:2: ( RULE_INT )
            {
            // InternalVideoEdit.g:1426:2: ( RULE_INT )
            // InternalVideoEdit.g:1427:3: RULE_INT
            {
             before(grammarAccess.getAudioLevelAccess().getLevelINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getAudioLevelAccess().getLevelINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AudioLevel__LevelAssignment_1"


    // $ANTLR start "rule__TimeCode__HoursAssignment_0"
    // InternalVideoEdit.g:1436:1: rule__TimeCode__HoursAssignment_0 : ( RULE_INT ) ;
    public final void rule__TimeCode__HoursAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1440:1: ( ( RULE_INT ) )
            // InternalVideoEdit.g:1441:2: ( RULE_INT )
            {
            // InternalVideoEdit.g:1441:2: ( RULE_INT )
            // InternalVideoEdit.g:1442:3: RULE_INT
            {
             before(grammarAccess.getTimeCodeAccess().getHoursINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTimeCodeAccess().getHoursINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__HoursAssignment_0"


    // $ANTLR start "rule__TimeCode__MinutesAssignment_2"
    // InternalVideoEdit.g:1451:1: rule__TimeCode__MinutesAssignment_2 : ( RULE_INT ) ;
    public final void rule__TimeCode__MinutesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1455:1: ( ( RULE_INT ) )
            // InternalVideoEdit.g:1456:2: ( RULE_INT )
            {
            // InternalVideoEdit.g:1456:2: ( RULE_INT )
            // InternalVideoEdit.g:1457:3: RULE_INT
            {
             before(grammarAccess.getTimeCodeAccess().getMinutesINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTimeCodeAccess().getMinutesINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__MinutesAssignment_2"


    // $ANTLR start "rule__TimeCode__SecondsAssignment_4"
    // InternalVideoEdit.g:1466:1: rule__TimeCode__SecondsAssignment_4 : ( RULE_INT ) ;
    public final void rule__TimeCode__SecondsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1470:1: ( ( RULE_INT ) )
            // InternalVideoEdit.g:1471:2: ( RULE_INT )
            {
            // InternalVideoEdit.g:1471:2: ( RULE_INT )
            // InternalVideoEdit.g:1472:3: RULE_INT
            {
             before(grammarAccess.getTimeCodeAccess().getSecondsINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTimeCodeAccess().getSecondsINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__SecondsAssignment_4"


    // $ANTLR start "rule__TimeCode__FramesAssignment_6"
    // InternalVideoEdit.g:1481:1: rule__TimeCode__FramesAssignment_6 : ( RULE_INT ) ;
    public final void rule__TimeCode__FramesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalVideoEdit.g:1485:1: ( ( RULE_INT ) )
            // InternalVideoEdit.g:1486:2: ( RULE_INT )
            {
            // InternalVideoEdit.g:1486:2: ( RULE_INT )
            // InternalVideoEdit.g:1487:3: RULE_INT
            {
             before(grammarAccess.getTimeCodeAccess().getFramesINTTerminalRuleCall_6_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTimeCodeAccess().getFramesINTTerminalRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeCode__FramesAssignment_6"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000C080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});

}